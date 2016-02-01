package com.mar.tmm.model.impl;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes rotational kinematic pair.
 */
public class RotationalPair extends AbstractKinematicPair {

    private final KinematicClass kinematicClass = KinematicClass.P4;
    private double angle;

    @Override
    public KinematicClass getKinematicClass() {
        return kinematicClass;
    }

    /**
     * Returns the angle beetween {@link #element1} and {@link #element2}.
     *
     * @return double value of angle
     */
    public double getAngle() {
        return angle;
    }

    public void setAngle(final double angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .appendSuper(super.toString())
            .append("kinematicClass", kinematicClass)
            .append("angle", angle)
            .toString();
    }
}
