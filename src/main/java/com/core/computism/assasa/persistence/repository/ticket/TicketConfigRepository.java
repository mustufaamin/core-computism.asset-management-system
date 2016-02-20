package com.core.computism.assasa.persistence.repository.ticket;

import com.core.computism.assasa.persistence.entity.ticket.TicketConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Venturedive on 8/24/2015.
 */
public interface TicketConfigRepository extends JpaRepository<TicketConfig, Long> {

    @Query("from TicketConfig tc where tc.problemType.id = :problemTypeId and tc.robotName in :robotNames")
    List<TicketConfig> findByProblemTypeAndRobot(@Param("problemTypeId") Long problemTypeId, @Param("robotNames") List<String> robotNames);
}
