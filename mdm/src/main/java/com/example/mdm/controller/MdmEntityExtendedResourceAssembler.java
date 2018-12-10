package com.example.mdm.controller;

import com.example.mdm.domain.vdb.MdmEntityExtended;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class MdmEntityExtendedResourceAssembler implements ResourceAssembler<MdmEntityExtended,
        Resource<MdmEntityExtended>> {

    @Override
    public Resource<MdmEntityExtended> toResource(MdmEntityExtended mdmEntityExtended) {

        return new Resource<>(mdmEntityExtended,
                linkTo(methodOn(MdmEntityController.class).getOneExtended(mdmEntityExtended.getId())).withSelfRel()
                );

    }

}
