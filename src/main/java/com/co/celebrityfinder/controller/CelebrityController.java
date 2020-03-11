package com.co.celebrityfinder.controller;

import com.co.celebrityfinder.service.api.ICelebrityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/celebrity")
public class CelebrityController {

    private ICelebrityService celebrityService;

    CelebrityController(ICelebrityService personService ){
        this.celebrityService = personService;
    }

    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return "celebrity";
    }

    @GetMapping("findCelebrity")
    ModelAndView home2() {
        ModelAndView modelAndView = new ModelAndView("celebrity");
        return modelAndView;
    }

    @PostMapping("findCelebrity")
    ModelAndView findCelebrity(@RequestParam("file") MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView("celebrity");

        if(!file.getOriginalFilename().endsWith(".csv")){
            modelAndView.addObject("message", "The file is not a csv file try with other file.");
            return modelAndView;
        }

        String messageError = null;

        int celebrityId = -1;
        try {
            celebrityId = celebrityService.findCelebrity(file.getInputStream());
        } catch (IOException e) {
            messageError = "Error reading the csvFile, please check your file.";
        }

        String messageResponse = null;

        if(messageError == null && celebrityId == -1) {
            messageResponse = "Celebrity is not present.";
        }else{
            messageResponse = "Celebrity is present in the row " + (celebrityId + 1);
        }

        modelAndView.addObject("message", messageResponse);
        return modelAndView;
    }
}
