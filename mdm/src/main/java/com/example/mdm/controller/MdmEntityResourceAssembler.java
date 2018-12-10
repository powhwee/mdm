package com.example.mdm.controller;

import com.example.mdm.domain.local.MdmEntity;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class MdmEntityResourceAssembler implements ResourceAssembler<MdmEntity,
        Resource<MdmEntity>> {

    @Override
    public Resource<MdmEntity> toResource(MdmEntity mdmEntity) {

        return new Resource<>(mdmEntity,
                linkTo(methodOn(MdmEntityController.class).getOne(mdmEntity.getId())).withSelfRel()
                );

    }

}
