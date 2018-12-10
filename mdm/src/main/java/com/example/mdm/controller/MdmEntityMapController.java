package com.example.mdm.controller;

import com.example.mdm.domain.local.MdmEntity;
import com.example.mdm.domain.local.MdmEntityMap;
import com.example.mdm.repository.local.MdmEntityMapRepository;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MdmEntityMapController {

    private final MdmEntityMapRepository repository;
    private final MdmEntityMapResourceAssembler assembler;

    MdmEntityMapController(MdmEntityMapRepository repository,
                           MdmEntityMapResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("mdmEntityMap/{id}")
    Resource<MdmEntity> getMap(@PathVariable Long id) {

        System.out.println("Entity map search done");
        // TODO: find by entityID
        MdmEntityMap entityIndex = repository.findById(id)
                .orElseThrow(()-> new MdmEntityMapNotFoundException(id));

        Resource rr =
                assembler.toResource(entityIndex);

        return rr;

    }


}
