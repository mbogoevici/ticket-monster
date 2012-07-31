package org.jboss.jdf.example.ticketmonster.rest;

import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Marius Bogoevici
 */
@Stateless
@Path("/carts")
public class CartService {

    @POST
    public CartSubresource createCart() {
        return new CartSubresource();
    }

    @Path("/{id}")
    public CartSubresource getCartById(@PathParam("id") String cartId) {
        return null;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCart(@PathParam("id") String cartId) {
        return;
    }

}
