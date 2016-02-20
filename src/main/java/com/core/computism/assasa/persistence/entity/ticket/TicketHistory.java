package com.core.computism.assasa.persistence.entity.ticket;

import com.core.computism.assasa.domain.type.TicketStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Venture Dive on 11/16/2015.
 */

@Entity
@Table(name="ticket_history")
public class TicketHistory extends BaseEntity {
    private static final long serialVersionUID = 591580523413849032L;

    private Ticket ticket;
    private Integer ticketStatus;
    private Agent changedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Column(name = "ticket_status" , nullable = false, precision = 11, scale = 0)
    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Transient
    public TicketStatus getTicketStatusType(){
        return TicketStatus.getTicketStatus(this.ticketStatus);
    }

    @Transient
    public void setTicketStatusType(TicketStatus ticketStatus){
        this.ticketStatus = ticketStatus.getCode();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by")
    public Agent getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Agent changedBy) {
        this.changedBy = changedBy;
    }

    @Override
    public String toString() {
        return new StringBuilder(
                "Ticket Id [" + ticket.getId()
                        + "], Ticket Status [" + getTicketStatusType()
                        + "], Changed By [" + changedBy.getId() + "]"
        ).toString();
    }
}
