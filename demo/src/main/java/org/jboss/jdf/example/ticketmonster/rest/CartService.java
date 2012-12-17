package org.jboss.jdf.example.ticketmonster.rest;

import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jboss.jdf.example.ticketmonster.model.Cart;
import org.jboss.jdf.example.ticketmonster.model.CartStore;

/**
 * @author Marius Bogoevici
 */
@Path("/carts")
@Stateless
public class CartService {

    @Inject
    private CartStore cartStore;

    @Inject
    private EntityManager entityManager;

    @POST
    public Cart openCart(Map<String, String> data) {
        Cart cart = Cart.initialize();
        cart.setPerformanceId(Long.parseLong(data.get("performance")));
        cartStore.saveCart(cart);
        return cart;
    }

    @GET
    @Path("/{id}")
    public Cart getCart(String id) {
      return cartStore.getCart(id);
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Cart addTicketRequest(@PathParam("id") String id, TicketRequest[] ticketRequests){
        Cart cart = cartStore.getCart(id);
        for (TicketRequest ticketRequest : ticketRequests) {
            cart.getTicketRequests().add(ticketRequest);
        }
        return cart;
    }
}
