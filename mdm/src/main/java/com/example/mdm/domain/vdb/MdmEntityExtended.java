package com.example.mdm.domain.vdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MDM Entity plus extended attributes
 * Extended attributes meaning attributes from external system-specific attributes
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="TBL_ENTITY_EXTENDED")
public class MdmEntityExtended {

    @Id
    @Column(name="MDM_ENTITY_ID")
    Long id;

    @Column(name="INDUSTRY_SEGMENT")
    private String industrySegment;

    @Column(name="LEGAL_NAME")
    private String legalName;

    @Column(name="LEGAL_ID")
    private String legalId;

    @Column(name="LEGAL_ADDRESS")
    private String legalAddress;


}
