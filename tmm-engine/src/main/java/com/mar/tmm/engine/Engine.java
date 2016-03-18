package com.mar.tmm.engine;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;

/**
 * Engine interface to define common functionality.
 */
public interface Engine {

    /**
     * Performs the whole mechanism recalculation by the given start pair and its change.
     *
     * @param mechanism mechanism to be recalculated
     * @param startPair start pair which position or angle is changed
     * @param change the value of change (angle or movement) of the start pair
     * @return the same mechanism which elements are recalculated and corresponds to the given change of the start pair
     * change
     */
    Mechanism calculate(Mechanism mechanism, KinematicPair startPair, double change);
}
