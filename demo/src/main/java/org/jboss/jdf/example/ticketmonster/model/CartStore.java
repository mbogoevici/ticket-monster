package org.jboss.jdf.example.ticketmonster.model;

/**
 * @author Marius Bogoevici
 */
public interface CartStore {

    public Cart getCart(String id);

    void saveCart(Cart cart);

    void delete(Cart cart);
}
