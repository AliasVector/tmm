package com.mar.tmm.model;

import java.util.List;

/**
 * Interface to describe the common behavior for mechanism group's unit.
 */
public interface Unit {
    /**
     * Returns the name of the unit.
     *
     * @return string with the name
     */
    String getName();

    /**
     * Return elements of this unit. Each element allows connect this unit to kinematic pair.
     *
     * @return list of {@link Element} instances
     */
    List<Element> getElements();

    /**
     * Defines element which connects the unit to kinematic pair.
     */
    interface Element {
        /**
         * Returns the disposition of this element inside Unit.
         *
         * @return {@link Disposition} instance
         */
        Disposition getDisposition();

        /**
         * Returns the related kinematic pair.
         *
         * @return {@link KinematicPair} instance
         */
        KinematicPair getKinematicPair();
    }
}
