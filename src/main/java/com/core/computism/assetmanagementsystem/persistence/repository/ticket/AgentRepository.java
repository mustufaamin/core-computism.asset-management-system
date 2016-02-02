package com.core.computism.assetmanagementsystem.persistence.repository.ticket;

import com.core.computism.assetmanagementsystem.persistence.entity.ticket.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Venture Dive on 11/16/2015.
 */
public interface AgentRepository  extends JpaRepository<Agent,Long>{

    Agent findByFirstNameAndLastName(String firstName, String lastName);
}
