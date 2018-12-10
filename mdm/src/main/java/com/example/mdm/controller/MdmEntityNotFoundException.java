package com.example.mdm.controller;

public class MdmEntityNotFoundException extends RuntimeException {

    public MdmEntityNotFoundException(Long id) {
        super("Could not find " + id);
    }
}
