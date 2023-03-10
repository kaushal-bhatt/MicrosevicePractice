package com.microservice.license.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private String Name;
    private String ContactName;
    private String ContactEmail;
    private String ContactPhone;
}
