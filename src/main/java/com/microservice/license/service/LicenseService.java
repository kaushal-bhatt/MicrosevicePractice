package com.microservice.license.service;

import com.microservice.license.Model.License;

import java.util.Locale;

public interface LicenseService {
     License getLicense(String licenseId, String organizationId,Locale locale);
     License getLicense(String licenseId, String organizationId,String locale);
     String createLicense(License license);
     String updateLicense(License license);
     String deleteLicense(String licenseId, Locale locale);
}
