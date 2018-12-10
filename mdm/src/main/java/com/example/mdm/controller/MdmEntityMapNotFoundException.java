package com.example.mdm.controller;

public class MdmEntityMapNotFoundException extends RuntimeException {

    public MdmEntityMapNotFoundException(Long id) {
        super("Could not find " + id);
    }
}
