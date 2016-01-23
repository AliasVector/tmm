package com.mar.tmm.model;

import java.util.List;

/**
 * Interface to describe the common behavior for all kind of mechanisms.
 */
public interface Mechanism {
    /**
     * Returns groups related to this mechanism.
     *
     * @return list of the groups
     */
    List<Group> getGroups();

    /**
     * Returns the name of the mechanism.
     *
     * @return string with the name
     */
    String getName();
}
