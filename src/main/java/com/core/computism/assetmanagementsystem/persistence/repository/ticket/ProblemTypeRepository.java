package com.core.computism.assetmanagementsystem.persistence.repository.ticket;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.ProblemType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Venturedive on 8/18/2015.
 */
public interface ProblemTypeRepository extends JpaRepository<ProblemType, Long> {

    ProblemType findByTypeCode(String typeCode);

}
