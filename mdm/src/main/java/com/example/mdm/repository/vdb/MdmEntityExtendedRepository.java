package com.example.mdm.repository.vdb;

import com.example.mdm.domain.vdb.MdmEntityExtended;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdmEntityExtendedRepository extends
        JpaRepository<MdmEntityExtended, Long> {
}
