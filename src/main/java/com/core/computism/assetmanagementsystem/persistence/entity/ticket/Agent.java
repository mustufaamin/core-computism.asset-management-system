package com.core.computism.assetmanagementsystem.persistence.entity.ticket;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venturedive on 8/17/2015.
 */
@Entity
@Table(name = "agent")
public class Agent extends BaseEntity {
    private static final long serialVersionUID = 6866053292905949144L;

    private String firstName;
    private String lastName;
    private Agent manager;
    private Date effectiveDate;
    private Date endDate;
    private long userId;

    private Set<Agent> agents = new HashSet<>(0);
    private Set<Ticket> tickets = new HashSet<>(0);
    private Set<Ticket> assignedByTickets = new HashSet<>(0);
    private Set<TicketHistory> ticketHistories = new HashSet<>(0);

    @Column(name = "first_name", nullable = false, length = 200)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 200)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_agent_id")
    public Agent getManager() {
        return manager;
    }

    public void setManager(Agent manager) {
        this.manager = manager;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "effective_date", nullable = false, length = 11)
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Column(name = "end_date", nullable = false, length = 11)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Column(name = "user_id", unique = true, nullable = false, precision = 11, scale = 0)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
    public Set<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Set<Agent> agents) {
        this.agents = agents;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agent")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "assignedByAgent")
    public Set<Ticket> getAssignedByTickets() {
        return assignedByTickets;
    }

    public void setAssignedByTickets(Set<Ticket> assignedByTickets) {
        this.assignedByTickets = assignedByTickets;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "changedBy")
    public Set<TicketHistory> getTicketHistories() {
        return ticketHistories;
    }

    public void setTicketHistories(Set<TicketHistory> ticketHistories) {
        this.ticketHistories = ticketHistories;
    }
}
