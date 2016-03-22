package com.mar.tmm.engine.delegate;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.impl.Unit;

/**
 * Recalculates the state of unit.
 */
public interface UnitVisitor {

    /**
     * Recalculates the internal state of unit regarding the given pair.
     *
     * @param unit unit to be recalculated
     * @param pair pair which was changed
     */
    void calculate(Unit unit, KinematicPair pair);
}
