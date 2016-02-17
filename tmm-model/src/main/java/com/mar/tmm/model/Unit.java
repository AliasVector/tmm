package com.mar.tmm.model;

import java.util.List;

import com.mar.tmm.model.impl.UnitElement;

/**
 * Interface to describe the common behavior for mechanism group's unit.
 */
public interface Unit extends EntityWithId {
    /**
     * Returns the name of the unit.
     *
     * @return string with the name
     */
    String getName();

    /**
     * Return elements of this unit. Each element allows connect this unit to kinematic pair.
     *
     * @return list of {@link UnitElement} instances
     */
    List<UnitElement> getElements();
}
