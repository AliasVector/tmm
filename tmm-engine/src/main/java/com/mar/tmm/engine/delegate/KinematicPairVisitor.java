package com.mar.tmm.engine.delegate;

import com.mar.tmm.model.KinematicPair;

/**
 * Recalculates the state of kinematic pair.
 */
public interface KinematicPairVisitor {

    /**
     * Recalculates the internal state of kinematic pair.
     *
     * @param pair   pair to be recalculated
     * @param change change of the pair
     */
    void calculate(KinematicPair pair, double change);
}
