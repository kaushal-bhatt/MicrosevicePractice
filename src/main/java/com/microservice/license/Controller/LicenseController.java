package com.microservice.license.Controller;

import com.microservice.license.Model.License;
import com.microservice.license.service.DoMultiply;
import com.microservice.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "v1/organization/license")
public class LicenseController {

    @RequestMapping(value = "/method")
    String myMethod(){
        return "abba";
    }

    @Autowired
    LicenseService licenseService;

    @Autowired
    DoMultiply doMultiply;

    @GetMapping("/getLicense")
    public ResponseEntity<License> license(@RequestParam("organizationId") String organizationId, @RequestParam("licenseId") String licenseId,@RequestHeader(value = "Accept-Language")Locale locale){
        License license= licenseService.getLicense(licenseId,organizationId,locale);
        license.add(linkTo(methodOn(LicenseController.class)
                        .license(organizationId, license.getLicenseId(),locale))
                        .withSelfRel(),
                linkTo(methodOn(LicenseController.class)
                        .CreateLicense( license, null))
                        .withRel("createLicense"),
                linkTo(methodOn(LicenseController.class)
                        .UpdateLicense( license))
                        .withRel("updateLicense"),
                linkTo(methodOn(LicenseController.class)
                        .deleteLicense( licenseId,locale))
                        .withRel("deleteLicense"));
        return new ResponseEntity<>(license, HttpStatus.OK);
    }

    @PostMapping("/createLicense")
    public ResponseEntity<String> CreateLicense( @RequestBody License license, @RequestHeader(value = "Accept-Language")Locale locale){
        String object= licenseService.createLicense(license);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PutMapping("/updateLicense")
    public ResponseEntity<String> UpdateLicense(@RequestBody License license){
        String object= licenseService.updateLicense(license);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteLicense")
    public ResponseEntity<String> deleteLicense(@RequestParam("licenseId") String licenseId,@RequestHeader(value = "Accept-Language") Locale locale){
        String license= licenseService.deleteLicense(licenseId,locale);
        return new ResponseEntity<>(license, HttpStatus.OK);
    }

    @RequestMapping(value="/{licenseId}/{clientType}",
            method = RequestMethod.GET)
    public License getLicensesWithClient(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId,
            @PathVariable("clientType") String clientType) {
        return licenseService.getLicense(organizationId,
                licenseId, clientType);
    }
}
