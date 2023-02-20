package com.microservice.license.service.Impl;

import com.microservice.license.Model.Table;
import com.microservice.license.service.DoMultiply;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultiplicationImpl implements DoMultiply {
    @Override
    public List<Integer> multiply(int a, int b) {
        List<Integer> array= new ArrayList<>();
        for(int i=1;i<=b;i++){

            int result=i*a;
            array.add(result);

        }
        return array;
    }
}
