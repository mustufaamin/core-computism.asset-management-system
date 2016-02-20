package com.core.computism.assasa.domain.type;

import java.util.HashMap;

/**
 * Created by M.Mustufa Amin Shah on 9/9/2015.
 */
public enum TicketPriority {
    NORMAL (1),
    URGENT (2),
    CRITICAL (3);

    private Integer code;
    private static HashMap<Integer,TicketPriority> ticketPriorities = new HashMap<>(0);

    static{
        for(TicketPriority ticketPriority : TicketPriority.values()){
            ticketPriorities.put(ticketPriority.code,ticketPriority);
        }
    }

    public static TicketPriority getTicketPriority(Integer value){
        return ticketPriorities.get(value);
    }


     TicketPriority(Integer value) {
         this.code = value;
    }

    public Integer getCode(){
        return this.code;
    }


}
