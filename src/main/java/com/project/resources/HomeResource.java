package com.project.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeResource {

    @GetMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("", "");

        return "home";
    }
}