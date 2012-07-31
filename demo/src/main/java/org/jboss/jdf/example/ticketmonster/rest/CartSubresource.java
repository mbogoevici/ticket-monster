package org.jboss.jdf.example.ticketmonster.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.jboss.jdf.example.ticketmonster.model.Seat;
import org.jboss.jdf.example.ticketmonster.model.Section;

/**
 * @author Marius Bogoevici
 */
public class CartSubresource {

    private String id;

    private Map<Section, List<Seat>> seatsInternal = new HashMap<Section, List<Seat>>();

    public String getId() {
        return id;
    }

    public Map<Long, List<Seat>> getSeats() {
        Map<Long, List<Seat>> seatsBySection = new HashMap<Long, List<Seat>>();
        for (Section section : seatsInternal.keySet()) {
            seatsBySection.put(section.getId(), new ArrayList<Seat>(seatsInternal.get(section.getId())));
        }
        return seatsBySection;
    }

    @GET
    public CartSubresource getContents() {
       return this;
    }

    @POST
    @Path("/seats")
    public CartSubresource addSeat(Seat s) {
        System.out.println("Adding an individual seat");
        this.getSeatsInternal().get(s.getSection()).add(s);
        return this;
    }

    @POST
    @Path("/seats/allocate")
    public CartSubresource addSeat(AllocationRequest bookingRequest) {
        System.out.println("Allocating");
        return this;
    }


    @JsonIgnore
    public Map<Section, List<Seat>> getSeatsInternal() {
        return seatsInternal;
    }


}
