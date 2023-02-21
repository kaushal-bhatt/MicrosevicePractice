package com.microservice.license.Controller;

import com.microservice.license.Model.License;
import com.microservice.license.service.Impl.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/organization/license")
public class LicenseController {

    @RequestMapping(value = "/method")
    String myMethod(){
        return "abba";
    }

    @Autowired
    LicenseService licenseService;
    @GetMapping("/")
    public ResponseEntity<License> getLicense(@RequestParam("organizationId") String organizationId,@RequestParam("licenseId") String licenseId){
        License license= licenseService.getLicense(licenseId,organizationId);
        return new ResponseEntity<>(license, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> CreateLicense(@RequestParam("organizationId") String organizationId,@RequestBody License license){
        String object= licenseService.createLicense(license,organizationId);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> UpdateLicense(@RequestParam("organizationId") String organizationId,@RequestBody License license){
        String object= licenseService.updateLicense(license,organizationId);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteLicense(@RequestParam("organizationId") String organizationId,@RequestParam("licenseId") String licenseId){
        String license= licenseService.deleteLicense(licenseId,organizationId);
        return new ResponseEntity<>(license, HttpStatus.OK);
    }
}
