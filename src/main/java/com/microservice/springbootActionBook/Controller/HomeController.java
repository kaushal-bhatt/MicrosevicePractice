package com.microservice.springbootActionBook.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @GetMapping("/greeting/{names}")
    public String greeting(@PathVariable String names, Model model) {
        model.addAttribute("name", names);
        return "greeting";
    }

    @GetMapping("/arooj/{name}")
    String mySecondMethod(@PathVariable String name,Model model){
        model.addAttribute("name",name);

        return "index";
    }
}
