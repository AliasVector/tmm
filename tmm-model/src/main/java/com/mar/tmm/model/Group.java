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
     * Returns the list of kinematic pairs of this group.
     *
     * @return list of kinematic pairs
     */
    List<KinematicPair> getKinematicPairs();
}
