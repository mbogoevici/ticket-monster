package org.jboss.jdf.ticketmonster.datagrid;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.infinispan.api.BasicCacheContainer;
import org.jboss.jdf.example.ticketmonster.model.Performance;
import org.jboss.jdf.example.ticketmonster.model.Seat;
import org.jboss.jdf.example.ticketmonster.model.Section;
import org.jboss.jdf.example.ticketmonster.service.AllocatedSeats;
import org.jboss.jdf.example.ticketmonster.service.SeatAllocationService;

/**
 * @author Marius Bogoevici
 */
@Alternative
public class DatagridSeatAllocationService implements SeatAllocationService {

    @Inject
    BasicCacheContainer container;

    @Override
    public AllocatedSeats allocateSeats(Section section, Performance performance, int seatCount, boolean contiguous) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deallocateSeats(Section section, Performance performance, List<Seat> seats) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void finalizeAllocation(AllocatedSeats allocatedSeats) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
