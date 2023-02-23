package com.microservice.license.service.Impl;

import com.microservice.license.Model.License;
import com.microservice.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    MessageSource messages;
    public License getLicense(String licenseId, String organizationId) {
//        License license = new License();
//        license.setId(new Random().nextInt(1000));
//        license.setLicenseId(licenseId);
//        license.setOrganizationId(organizationId);
//        license.setDescription("Software product");
//        license.setProductName("Ostock");
//        license.setLicenseType("full");

        return new License(new Random().nextInt(1000),licenseId,organizationId,"Software product","Ostock","full");
    }


    public String createLicense(License license, String organizationId, Locale locale){
        String responseMessage = null;
        if(license != null) {
            license.setOrganizationId(organizationId);
             responseMessage = String.format(messages.getMessage(
                            "license.create.message", null,locale),
                    license);
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId,Locale locale){
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage(
                            "license.update.message", null, locale),
                    license);
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId,Locale locale){

        String responseMessage = null;
        responseMessage = String.format(messages.getMessage(
                        "license.delete.message", null, locale),
                licenseId);
        return responseMessage;
    }
}


