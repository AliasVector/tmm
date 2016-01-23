package com.mar.tmm.model;

/**
 * Interface to describe the common behavior for mechanism group's element.
 */
public interface KinematicPair {
    /**
     * Returns the name of the kinematic pair.
     *
     * @return string with the name
     */
    String getName();

    Unit getUnit();

    Unit getUnit2();
}
