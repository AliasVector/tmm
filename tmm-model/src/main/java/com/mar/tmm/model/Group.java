package com.mar.tmm.model;

import com.mar.tmm.model.impl.Unit;

/**
 * Interface to describe the common behavior for mechanism group.
 */
public interface Group extends EntityWithId {

    /**
     * Returns the type of the group.
     *
     * @return instance of type {@link GroupType}
     */
    GroupType getType();

    /**
     * Returns the name of the group.
     *
     * @return string with the name
     */
    String getName();

    KinematicPair getExternalPair1();

    KinematicPair getExternalPair2();

    KinematicPair getInternalPair();

    Unit getUnit1();

    Unit getUnit2();

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
