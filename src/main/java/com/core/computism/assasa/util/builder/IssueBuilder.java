package com.core.computism.assasa.util.builder;

import com.amazonaws.services.sqs.model.Message;
import com.core.computism.assasa.domain.IssueDTO;
import com.core.computism.assasa.persistence.entity.ticket.Ticket;
import com.core.computism.assasa.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venturedive on 7/8/2015.
 */

public class IssueBuilder {

    private static final Logger LOGGER = Logger.getLogger(IssueBuilder.class);

    public List<IssueDTO> buildIssues(List<Message> messages) {
        int size = messages == null ? 0 : messages.size();
        List<IssueDTO> result = new ArrayList<>(size);
        ObjectMapper mapper = JsonUtil.getMapper();

        for (int i = 0; i < size; i++) {
            String message = messages.get(i).getBody();
            try {
                IssueDTO issue = mapper.readValue(message, IssueDTO.class);
                result.add(issue);

            } catch (IOException e) {
                LOGGER.error("Error parsing JSON [" + message + "]", e);
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<IssueDTO> buildIssuesFromTickets(List<Ticket> tickets) {
        List<IssueDTO> result = new ArrayList<>(tickets.size());
        for (Ticket ticket : tickets) {
            IssueDTO issue = buildIssue(ticket);
            result.add(issue);
        }
        return result;
    }

    //TODO: Need to optimize the below as taking too long
    public IssueDTO buildIssue(Ticket ticket) {
        IssueDTO issue = new IssueDTO();
        issue.setBookingId(ticket.getBookingInfo().getBookingId());
        issue.setRobotName(ticket.getRobotName());
        issue.setProblemType(ticket.getProblemType().getTypeCode());
        return issue;
    }
}
