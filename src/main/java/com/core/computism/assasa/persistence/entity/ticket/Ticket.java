package com.core.computism.assasa.persistence.entity.ticket;

import com.core.computism.assasa.domain.type.TicketPriority;
import com.core.computism.assasa.domain.type.TicketStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venturedive on 8/17/2015.
 */
@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {
    private static final long serialVersionUID = 1066143420365697894L;

    private BookingInfo bookingInfo;
    private ProblemType problemType;
    private String robotName;
    private String title;
    private String actionRequired;
    private Integer ticketStatus;
    private Integer autoExpireMin;
    private Integer snoozedMin;
    private Agent agent;
    private Date assignedDate;
    private Agent assignedByAgent;
    private Date acceptedDate;
    private Date resolvedDate;
    private String agentNotes;
    private Integer ticketPriority;
    private Date snoozedDate;

    private Set<TicketHistory> ticketHistories = new HashSet<>(0);

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "snoozed_date", length = 11)
    public Date getSnoozedDate() {
        return snoozedDate;
    }

    public void setSnoozedDate(Date snoozedDate) {
        this.snoozedDate = snoozedDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_info_id")
    public BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_type_id")
    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    @Column(name = "robot_name", nullable = false, length = 200)
    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    @Column(name = "title", nullable = false, length = 250)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "action_required", nullable = false, length = 500)
    public String getActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(String actionRequired) {
        this.actionRequired = actionRequired;
    }

    @Column(name = "ticket_status", nullable = false, precision = 11, scale = 0)
    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Transient
    public TicketStatus getTicketStatusType() {
        return TicketStatus.getTicketStatus(this.ticketStatus);
    }

    @Transient
    public void setTicketStatus(TicketStatus status) {
        if (status != null) {
            this.ticketStatus = status.getCode();
        }
    }

    @Column(name = "auto_expire_min", nullable = false, precision = 11, scale = 0)
    public Integer getAutoExpireMin() {
        return autoExpireMin;
    }

    public void setAutoExpireMin(Integer autoExpireMin) {
        this.autoExpireMin = autoExpireMin;
    }

    @Column(name = "snoozed_min", precision = 11, scale = 0)
    public Integer getSnoozedMin() {
        return snoozedMin;
    }

    public void setSnoozedMin(Integer snoozedMin) {
        this.snoozedMin = snoozedMin;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "assigned_date", length = 11)
    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_by_agent_id")
    public Agent getAssignedByAgent() {
        return assignedByAgent;
    }

    public void setAssignedByAgent(Agent assignedByAgent) {
        this.assignedByAgent = assignedByAgent;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "accepted_date", length = 11)
    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "resolved_date", length = 11)
    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @Column(name = "agent_notes", length = 500)
    public String getAgentNotes() {
        return agentNotes;
    }

    public void setAgentNotes(String agentNotes) {
        this.agentNotes = agentNotes;
    }

    @Column(name = "ticket_priority", nullable = false, precision = 11, scale = 0)
    public Integer getTicketPriority() {
        return ticketPriority;
    }

    public void setTicketPriority(Integer ticketPriority) {
        this.ticketPriority = ticketPriority;
    }

    @Transient
    public TicketPriority getTicketPriorityType(){
        return TicketPriority.getTicketPriority(this.ticketPriority);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ticket")
    public Set<TicketHistory> getTicketHistories() {
        return ticketHistories;
    }

    public void setTicketHistories(Set<TicketHistory> ticketHistories) {
        this.ticketHistories = ticketHistories;
    }

    public void setTicketPriority(TicketPriority priority){
        if (priority != null) {
            this.ticketPriority = priority.getCode();
        }
    }
}
