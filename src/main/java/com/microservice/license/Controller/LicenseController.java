package com.microservice.license.Controller;

import com.microservice.license.Model.License;
import com.microservice.license.service.Impl.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

    @RequestMapping(value = "/method")
    String myMethod(){
        return "abba";
    }

    @Autowired
    LicenseService licenseService;
    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,@PathVariable("licenseId") String licenseId){
        License license= licenseService.getLicense(licenseId,organizationId);
        return new ResponseEntity<>(license, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> CreateLicense(@PathVariable("organizationId") String organizationId,@RequestBody License license){
        String object= licenseService.createLicense(license,organizationId);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> UpdateLicense(@PathVariable("organizationId") String organizationId,@RequestBody License license){
        String object= licenseService.updateLicense(license,organizationId);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,@PathVariable("licenseId") String licenseId){
        String license= licenseService.deleteLicense(licenseId,organizationId);
        return new ResponseEntity<>(license, HttpStatus.OK);
    }
}
