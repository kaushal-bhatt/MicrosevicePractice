package com.microservice.license.service.Impl;

import com.microservice.license.Model.License;
import com.microservice.license.Model.Organization;
import com.microservice.license.Repo.LicenseRepository;
import com.microservice.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    MessageSource messages;

    @Autowired
    LicenseRepository licenseRepository;
    public License getLicense(String licenseId, String organizationId,Locale locale) {
      License license=  licenseRepository.findByOrganizationIdAndLicenseId(organizationId,licenseId);
      if(license==null){
          throw new IllegalArgumentException(
                  String.format(messages.getMessage(
                                  "license.search.error.message", null, locale),
                          licenseId, organizationId));
      }
        return license;
    }

    public License getLicense(String licenseId, String organizationId, String
            clientType){
        License license = licenseRepository.findByOrganizationIdAndLicenseId
                (organizationId, licenseId);
        if (null == license) {
            throw new IllegalArgumentException(String.format(
                    messages.getMessage("license.search.error.message", null, null),
                    licenseId, organizationId));
        }
        Organization organization = retrieveOrganizationInfo(organizationId,
                clientType);
        if (null != organization) {
            license.setOrganizationName(organization.getName());
            license.setContactName(organization.getContactName());
            license.setContactEmail(organization.getContactEmail());
            license.setContactPhone(organization.getContactPhone());
        }
        return license;
    }


    public String createLicense(License license){
        String licenseId=null;
        if(license != null) {
            license.setLicenseId(UUID.randomUUID().toString());
            licenseRepository.save(license);
            licenseId=license.getLicenseId();

        }
        return "License has been created successfully!! and license ID is :"+licenseId;
    }

    public String updateLicense(License license){

        if (license != null) {
         licenseRepository.save(license);
        }
        return "License has been updated!!";
    }

    public String deleteLicense(String licenseId,Locale locale){

        licenseRepository.deleteById(licenseId);
        String responseMessage = null;
        responseMessage = String.format(messages.getMessage(
                        "license.delete.message", null, locale),
                licenseId);
        return responseMessage;
    }

   private Organization retrieveOrganizationInfo(String organizationId,
                             String clientType){
        return new Organization();

    }
}


