package com.core.computism.assasa.domain;


/**
 * A domain model, used to fetch problems from Queue.
 * Created by Salman on 7/8/2015.
 */
public class IssueDTO {

    private Integer bookingId;
    private String robotName;
    private String problemType;

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public String getProblemType() {
        return problemType;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProblemTypeDTO: ").append(problemType)
                .append(", RobotName: ").append(robotName)
                .append(", BookingId: ").append(bookingId);
        return builder.toString();
    }
}
