package com.project.resources;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class FrontResource {

    @GetMapping("/")
    public String home(ModelMap model) {
    	
        model.addAttribute("attribute", "Rômulo Albuquerque");

        return "index";
    }
       
}