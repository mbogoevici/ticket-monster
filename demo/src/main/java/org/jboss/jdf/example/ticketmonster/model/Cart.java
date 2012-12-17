package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jboss.jdf.example.ticketmonster.rest.TicketRequest;

/**
 * @author Marius Bogoevici
 */
public class Cart implements Serializable  {

    private String id;

    private Long performanceId;

    private ArrayList<TicketRequest> ticketRequests = new ArrayList<TicketRequest>();


    private Cart() {
    }

    private Cart(String id) {
        this.id = id;
    }

    public static Cart initialize() {
        return new Cart(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public List<TicketRequest> getTicketRequests() {
        return ticketRequests;
    }

}
