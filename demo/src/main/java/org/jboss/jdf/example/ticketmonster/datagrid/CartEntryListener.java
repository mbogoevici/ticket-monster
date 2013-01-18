package org.jboss.jdf.example.ticketmonster.datagrid;

import org.infinispan.notifications.Listener;
import org.jboss.jdf.example.ticketmonster.model.Event;

@Listener
public class CartEntryListener {


    public void onRemoval(Event event) {
         System.out.println(event.getCategory());
    }
}
