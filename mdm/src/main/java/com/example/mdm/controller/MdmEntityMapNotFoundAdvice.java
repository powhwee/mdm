package com.example.mdm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MdmEntityMapNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MdmEntityMapNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String mdmEntityIndexNotFoundHandler(MdmEntityMapNotFoundException ex) {
        return ex.getMessage();
    }
}
