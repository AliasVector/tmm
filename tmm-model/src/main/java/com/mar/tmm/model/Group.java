package com.mar.tmm.model;

import java.util.List;

/**
 * Interface to describe the common behavior for mechanism group.
 */
public interface Group {
    /**
     * Returns the name of the group.
     *
     * @return string with the name
     */
    String getName();

    /**
     * Returns the list of external kinematic pairs of this group.
     *
     * @return list of external kinematic pairs
     */
    List<KinematicPair> getExternalKinematicPairs();

    /**
     * Calculates the freedom degrees of this group. Evaluates the amount of kinematic pairs of the group and the amount
     * of units and calculates by using the formula: W = 3*n - 2*p5 - p4, where W - freedom degrees,
     * n - amount of units,
     * p5 - amount of kinematic pairs of 5th class, see {@link com.mar.tmm.model.KinematicPair.KinematicClass}.
     * p4 - amount of kinematic pairs of 4th class, see {@link com.mar.tmm.model.KinematicPair.KinematicClass}.
     *
     * @return integer value of freedom degree
     */
    int calculateFreedomDegrees();
}
