package com.mar.tmm.model.impl;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes translational kinematic pair.
 */
public class TranslationalPair extends AbstractKinematicPair {

    private final KinematicClass kinematicClass = KinematicClass.P4;
    private double movement;

    @Override
    public KinematicClass getKinematicClass() {
        return kinematicClass;
    }

    /**
     * Returns the angle beetween {@link #element1} and {@link #element2}.
     *
     * @return double value of angle
     */
    public double getMovement() {
        return movement;
    }

    public void setMovement(final double movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .appendSuper(super.toString())
            .append("kinematicClass", kinematicClass)
            .append("movement", movement)
            .toString();
    }
}