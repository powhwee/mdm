package com.example.mdm.controller;

import com.example.mdm.domain.local.MdmEntityMap;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class MdmEntityMapResourceAssembler implements ResourceAssembler<MdmEntityMap,
        Resource<MdmEntityMap>> {


    @Override
    public Resource<MdmEntityMap> toResource(MdmEntityMap mdmEntityMap) {

        return new Resource<>(mdmEntityMap,
                linkTo(methodOn(MdmEntityMapController.class).getMap(mdmEntityMap.getId())).withSelfRel()
                );

    }


}
