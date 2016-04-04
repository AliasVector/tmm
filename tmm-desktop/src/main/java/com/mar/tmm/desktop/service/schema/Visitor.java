package com.mar.tmm.desktop.service.schema;

import com.mar.tmm.model.impl.Unit;

/**
 * Interface for all visitors which are used for recalculation of the specific mechanism unit's elements.
 */
public interface Visitor {
    /**
     * Perform recalculation of the unit
     * @param unit 
     */
    void recalculate(Unit unit);
}
