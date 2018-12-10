package com.example.mdm.controller;

import com.example.mdm.domain.local.MdmEntity;
import com.example.mdm.domain.vdb.MdmEntityExtended;
import com.example.mdm.repository.vdb.MdmEntityExtendedRepository;
import com.example.mdm.repository.local.MdmEntityRepository;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MdmEntityController {

    private final MdmEntityRepository mdmEntityRepository;
    private final MdmEntityResourceAssembler mdmEntityResourceAssembler;
    private final MdmEntityExtendedRepository  mdmEntityExtendedRepository;
    private final MdmEntityExtendedResourceAssembler mdmEntityExtendedResourceAssembler;

    MdmEntityController(MdmEntityRepository repository,
                        MdmEntityExtendedRepository mdmEntityExtendedRepository,
                        MdmEntityResourceAssembler assembler,
                        MdmEntityExtendedResourceAssembler extendedAssembler) {
        this.mdmEntityRepository = repository;
        this.mdmEntityExtendedRepository = mdmEntityExtendedRepository;
        this.mdmEntityResourceAssembler = assembler;
        this.mdmEntityExtendedResourceAssembler = extendedAssembler;
    }

    @GetMapping("mdmEntity/{id}")
    Resource<MdmEntity> getOne(@PathVariable Long id) {

        MdmEntity entity = mdmEntityRepository.findById(id)
                .orElseThrow(()-> new MdmEntityNotFoundException(id));

        Resource rr =
                mdmEntityResourceAssembler.toResource(entity);

        return rr;

    }

    @GetMapping("mdmEntityExtended/{id}")
    Resource<MdmEntityExtended> getOneExtended(@PathVariable Long id) {

        MdmEntityExtended entity = mdmEntityExtendedRepository.findById(id)
                .orElseThrow(()-> new MdmEntityNotFoundException(id));

        Resource rr =
                mdmEntityExtendedResourceAssembler.toResource(entity);

        return rr;

    }


}
