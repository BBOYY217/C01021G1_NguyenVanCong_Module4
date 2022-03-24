package com.example.case_study.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDto implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
