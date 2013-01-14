package org.jboss.jdf.example.ticketmonster.model;

import org.infinispan.notifications.Listener;

@Listener
public class CartEntryListener {


    public void onRemoval(Event event) {
         System.out.println(event.getCategory());
    }
}
