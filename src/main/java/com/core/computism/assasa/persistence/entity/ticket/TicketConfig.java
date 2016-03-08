package com.core.computism.assasa.persistence.entity.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Venturedive on 8/17/2015.
 */
@Entity
@Table(name = "ticket_config")
public class TicketConfig extends BaseEntity {
    private static final long serialVersionUID = -1147043711655313287L;

    private ProblemType problemType;
    private String robotName;
    private String actionRequired;
    private Integer autoExpireMin;

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

    @Column(name = "action_required", nullable = false, length = 500)
    public String getActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(String actionRequired) {
        this.actionRequired = actionRequired;
    }

    @Column(name = "auto_expire_min", nullable = false, precision = 11, scale = 0)
    public Integer getAutoExpireMin() {
        return autoExpireMin;
    }

    public void setAutoExpireMin(Integer autoExpireMin) {
        this.autoExpireMin = autoExpireMin;
    }
}
