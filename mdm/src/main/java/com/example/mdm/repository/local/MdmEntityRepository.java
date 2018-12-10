package com.example.mdm.repository.local;

import com.example.mdm.domain.local.MdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdmEntityRepository extends JpaRepository <MdmEntity, Long>
{
}
