package com.microservice.license.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

    @RequestMapping(value = "/method")
    String myMethod(){
        return "abba";
    }
}
