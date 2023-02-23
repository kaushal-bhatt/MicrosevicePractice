package com.microservice.license.Model;


import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class License extends RepresentationModel<License> {
    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;


}
//{"id":123,"licenseId":"kaushal8650","description":"kaushal ka license"}