package com.example.mdm.domain.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TBL_MDM_ENTITY_MAP")
public class MdmEntityMap {

    @Id
//    @GeneratedValue
    @Column(name="MDM_ENTITY_MAP_ID")
    private Long id;

    @Column(name="EXT_SYSTEM_CODE")
    private String systemCode; // can be made an ENUM to be code-value-checked

    @Column(name="RELATIONSHIP_CODE")
    private String relationshipCode;  // can be made an ENUM to be code-value-checked

    @Column(name="EXT_SYSTEM_ENTITY_ID")
    private String systemEntityId;
    // the ID used by downstream systems to identity the identity, their 'proprietory' ID

}
