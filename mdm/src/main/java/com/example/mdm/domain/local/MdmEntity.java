package com.example.mdm.domain.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TBL_MDM_ENTITY")
public class MdmEntity {

    @Id
    @GeneratedValue
    @Column(name="MDM_ENTITY_ID")
    private Long id;

    @Column(name="LEGAL_NAME")
    private String legalName;

    @Column(name="LEGAL_ID")
    private String legalId;

    @Column(name="LEGAL_ADDRESS")
    private String legalAddress;

}
