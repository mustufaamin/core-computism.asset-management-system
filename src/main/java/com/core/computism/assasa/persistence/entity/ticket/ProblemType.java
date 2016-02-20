package com.core.computism.assasa.persistence.entity.ticket;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venturedive on 8/17/2015.
 */
@Entity
@Table(name = "problem_type")
public class ProblemType extends BaseEntity {
    private static final long serialVersionUID = -2061555012776050489L;

    private String typeCode;
    private String descr;

    private Set<TicketConfig> ticketConfigs = new HashSet<>(0);
    private Set<Ticket> tickets = new HashSet<>(0);

    @Column(name = "type_code", nullable = false, length = 100)
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Column(name = "descr", nullable = false, length = 200)
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problemType")
    public Set<TicketConfig> getTicketConfigs() {
        return ticketConfigs;
    }

    public void setTicketConfigs(Set<TicketConfig> ticketConfigs) {
        this.ticketConfigs = ticketConfigs;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problemType")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
