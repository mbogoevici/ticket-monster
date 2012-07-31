package org.jboss.jdf.example.ticketmonster.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
public class AllocationRequest {

    List<TicketRequest> ticketRequests = new ArrayList<TicketRequest>();


    public AllocationRequest() {
    }

    public AllocationRequest(List<TicketRequest> ticketRequests) {
        this.ticketRequests = ticketRequests;
    }

    public List<TicketRequest> getTicketRequests() {
        return ticketRequests;
    }
}
