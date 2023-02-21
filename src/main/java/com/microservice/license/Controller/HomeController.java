package com.microservice.license.Controller;


import com.microservice.license.Model.Multiplication;
import com.microservice.license.service.DoMultiply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
public class HomeController {



    @Autowired
    DoMultiply doMultiply;

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

    @GetMapping("/multiply/{number}/{tillNumber}")
    Multiplication multi(@PathVariable int number,@PathVariable int tillNumber){

        Multiplication multiplication= new Multiplication();
        multiplication.setNumber(number);
        multiplication.setTable(doMultiply.multiply(number,tillNumber));
        return multiplication;
    }
}
