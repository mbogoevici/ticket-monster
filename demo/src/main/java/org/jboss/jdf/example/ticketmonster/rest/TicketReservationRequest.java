package org.jboss.jdf.example.ticketmonster.rest;

import org.jboss.jdf.example.ticketmonster.model.TicketPrice;

/**
 * <p>
 * A {@link org.jboss.jdf.example.ticketmonster.rest.BookingRequest} will contain multiple {@link org.jboss.jdf.example.ticketmonster.rest.TicketReservationRequest}s.
 * </p>
 *
 * @author Marius Bogoevici
 * @author Pete Muir
 *
 */
public class TicketReservationRequest {

    private long ticketPrice;

    private int quantity;

    public TicketReservationRequest() {
        // Empty constructor
    }

    public TicketReservationRequest(TicketPrice ticketPrice, int quantity) {
        this.ticketPrice = ticketPrice.getId();
        this.quantity = quantity;
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
