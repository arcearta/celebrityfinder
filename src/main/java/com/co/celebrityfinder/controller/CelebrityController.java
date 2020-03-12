package com.co.celebrityfinder.controller;

import com.co.celebrityfinder.service.api.ICelebrityService;

import com.co.celebrityfinder.service.dto.PersonDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/celebrity")
public class CelebrityController {

    static Logger log = Logger.getLogger(CelebrityController.class.getName());

    private static final String CELEBRITY_NOT_PRESENT = "Celebrity is not present.";
    private static final String CELEBRITY_IS_PRESENT = "Celebrity is present in the row: ";
    private static final String VIEW_TEMPLATE_NAME = "celebrity";

    private ICelebrityService celebrityService;

    CelebrityController(ICelebrityService personService ){
        this.celebrityService = personService;
    }

   @RequestMapping(method = RequestMethod.GET)
    String home() {
        return VIEW_TEMPLATE_NAME;
    }

    @GetMapping("findCelebrity")
    ModelAndView home2() {
        ModelAndView modelAndView = new ModelAndView(VIEW_TEMPLATE_NAME);
        return modelAndView;
    }

    @PostMapping("findCelebrity")
    ModelAndView findCelebrity(@RequestParam("file") MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView(VIEW_TEMPLATE_NAME);

        if(!file.getOriginalFilename().endsWith(".csv")){
            modelAndView.addObject("message", "The file is not a csv file try with other file.");
            return modelAndView;
        }

        String messageError = null;
        PersonDto celebrityPerson = null;

        try {
            celebrityPerson = celebrityService.findCelebrity(file.getInputStream());
        } catch (IOException e) {
            log.info(e.getMessage());
            messageError = "Error reading the csvFile, please check your file structure:";
        }

        String messageResponse = null;

        if(messageError == null && celebrityPerson == null) {
            messageResponse = CELEBRITY_NOT_PRESENT;
        }else{
            messageResponse = CELEBRITY_IS_PRESENT + (celebrityPerson.getPersonId() + 1);
        }

        modelAndView.addObject("message", messageResponse);
        return modelAndView;
    }
}
