package com.co.celebrityfinder.controller;

import com.co.celebrityfinder.service.api.IPersonService;
import com.co.celebrityfinder.service.dto.PeopleDto;
import com.co.celebrityfinder.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return "people";
    }

    @GetMapping("findCelebrity")
    ModelAndView home2() {
        ModelAndView modelAndView = new ModelAndView("people");
        return modelAndView;
    }

    @PostMapping("/findCelebrity")
    ModelAndView findCelebrity(@RequestParam("file") MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView("people");

        if(!file.getOriginalFilename().endsWith(".csv")){
            modelAndView.addObject("message", "The file is not a csv file try with other file.");
            return modelAndView;
        }

        int celebrityId = -1;
        try {
            CsvReader readCsv = new CsvReader();
            PeopleDto peopleDto = new PeopleDto(readCsv.readFile(file.getInputStream()));
            celebrityId = personService.findCelebrity(peopleDto);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String messageResponse = "";
        if(celebrityId == -1) {
            messageResponse = "Celebrity is not present.";
        }else{
            messageResponse = "Celebrity is present in the row " + (celebrityId + 1);
        }

        modelAndView.addObject("message", messageResponse);
        return modelAndView;
    }
}
