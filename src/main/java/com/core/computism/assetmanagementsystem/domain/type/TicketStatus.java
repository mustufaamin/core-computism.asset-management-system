package com.core.computism.assetmanagementsystem.domain.type;

import java.util.HashMap;

/**
 * Created by Venturedive on 8/24/2015.
 */
public enum TicketStatus {
    NEW(1),
    ASSIGNED (2),
    ACCEPTED (3),
    SNOOZED (4),
    AGENT_RESOLVED (5),
    FALSE_ALARM (6),
    SYSTEM_RESOLVED (7),
    CLOSED(8);

    private Integer code;
    private static HashMap<Integer, TicketStatus> ticketStatuses = new HashMap<>(0);

    static {
        for (TicketStatus status : TicketStatus.values()) {
            ticketStatuses.put(status.getCode(), status);
        }
    }

    public static TicketStatus getTicketStatus(Integer value) {
        return ticketStatuses.get(value);
    }

    private TicketStatus(Integer value) {
        this.code = value;
    }

    public Integer getCode() {
        return this.code;
    }
}
