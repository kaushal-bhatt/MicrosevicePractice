package com.microservice.license.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class Multiplication {
    private int number;
    private List<?> table;
}
