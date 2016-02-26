package com.mar.tmm.model;

import java.util.List;

import com.mar.tmm.model.impl.Unit;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;

/**
 * Interface to describe the common behavior for all kind of mechanisms.
 */
public interface Mechanism extends EntityWithId {
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

    /**
     * Returns rack unit of this mechanism.
     *
     * @return {@link Unit} instance
     */
    Unit getRackUnit();

    /**
     * Returns lever unit of this mechanism.
     *
     * @return {@link Unit} instance
     */
    Unit getLeverUnit();

    /**
     * Returns kinematic pair of the mechanism.
     *
     * @return {@link KinematicPair} instance
     */
    KinematicPair getKinematicPair();

    /**
     * Connects group's external kinematic pair to this mechanism.
     *
     * @param groupPair external kinematic pair of the group to be connected to mechanism. Free element of the
     *                  group's kinematic pair is used to connect mechanism's lever.
     */
    void connectGroupToMechanism(Group group, AbstractKinematicPair groupPair);
}
