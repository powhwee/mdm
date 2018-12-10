package com.example.mdm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MdmEntityNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MdmEntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String mdmEntityNotFoundHandler(MdmEntityNotFoundException ex) {
        return ex.getMessage();
    }
}
