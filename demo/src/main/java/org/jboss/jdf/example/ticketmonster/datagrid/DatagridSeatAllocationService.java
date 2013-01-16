package org.jboss.jdf.example.ticketmonster.datagrid;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;
import org.jboss.jdf.example.ticketmonster.model.*;
import org.jboss.jdf.example.ticketmonster.service.AllocatedSeats;
import org.jboss.jdf.example.ticketmonster.service.SeatAllocationService;

/**
 * @author Marius Bogoevici
 */
@Alternative
public class DatagridSeatAllocationService implements SeatAllocationService {


    public static final String ALLOCATIONS = "TICKETMONSTER_ALLOCATIONS";

    private final Cache<AllocationKey, SectionAllocation> cache;

    @Inject
    public DatagridSeatAllocationService(EmbeddedCacheManager basicCacheContainer) {
        this.cache = basicCacheContainer.getCache(ALLOCATIONS);
    }


    @Override
    public AllocatedSeats allocateSeats(Section section, Performance performance, int seatCount, boolean contiguous) {
        AllocationKey allocationKey = AllocationKey.of(section, performance);
        cache.putIfAbsent(allocationKey, new SectionAllocation(performance, section));
        cache.getAdvancedCache().lock(allocationKey);
        SectionAllocation allocation = cache.get(allocationKey);
        ArrayList<Seat> seats = allocation.allocateSeats(seatCount, contiguous);
        cache.put(allocationKey, allocation);
        return new AllocatedSeats(allocation, seats);
    }

    @Override
    public void deallocateSeats(Section section, Performance performance, List<Seat> seats) {
        cache.putIfAbsent(AllocationKey.of(section, performance), new SectionAllocation());
        SectionAllocation sectionAllocation = cache.get(AllocationKey.of(section, performance));
        for (Seat seat : seats) {
            if (!seat.getSection().equals(section)) {
                throw new SeatAllocationException("All seats must be in the same section!");
            }
            sectionAllocation.deallocate(seat);
        }
    }

    @Override
    public void finalizeAllocation(AllocatedSeats allocatedSeats) {
        allocatedSeats.markOccupied();
    }

    @Override
    public void finalizeAllocation(Performance performance, List<Seat> allocatedSeats) {
            SectionAllocation sectionAllocation = cache.get(AllocationKey.of(allocatedSeats.get(0).getSection(), performance));
            sectionAllocation.markOccupied(allocatedSeats);
    }
}
