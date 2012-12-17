package org.jboss.jdf.example.ticketmonster.model;

import javax.inject.Inject;

import org.infinispan.api.BasicCache;
import org.infinispan.api.BasicCacheContainer;

/**
 * @author Marius Bogoevici
 */
public class DatagridCartStore implements CartStore {

    public static final String CARTS_CACHE = "carts";

    private final BasicCache<String, Cart> cartsCache;

    @Inject
    public DatagridCartStore(BasicCacheContainer container) {

        this.cartsCache = container.getCache(CARTS_CACHE);
    }

    @Override
    public Cart getCart(String cartId) {
        return this.cartsCache.get(cartId);
    }

    @Override
    public void saveCart(Cart cart) {
        this.cartsCache.put(cart.getId(), cart);
    }

    @Override
    public void delete(Cart cart) {
        this.cartsCache.remove(cart.getId());
    }
}
