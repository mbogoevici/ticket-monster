package org.jboss.jdf.ticketmonster.datagrid;

import org.jboss.jdf.example.ticketmonster.model.Performance;
import org.jboss.jdf.example.ticketmonster.model.Section;

import java.io.Serializable;

public class AllocationKey implements Serializable {

    private final Section section;
    private final Performance performance;

    private AllocationKey(Section section, Performance performance) {

        this.section = section;
        this.performance = performance;
    }

    public static AllocationKey of (Section section, Performance performance) {
        return new AllocationKey(section, performance);
    }


    public Section getSection() {
        return section;
    }

    public Performance getPerformance() {
        return performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllocationKey that = (AllocationKey) o;

        if (performance != null ? !performance.equals(that.performance) : that.performance != null) return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = section != null ? section.hashCode() : 0;
        result = 31 * result + (performance != null ? performance.hashCode() : 0);
        return result;
    }
}
