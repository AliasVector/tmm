package com.mar.tmm.model.impl.kinematicpair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes rotational kinematic pair.
 */
@XmlType(name = "RotationalPair")
@XmlAccessorType(XmlAccessType.FIELD)
public class RotationalPair extends AbstractKinematicPair {

    @XmlElement
    private final KinematicClass kinematicClass = KinematicClass.P4;

    @XmlElement(name = "angle")
    private double angle = 0;

    public RotationalPair() {
    }

    public RotationalPair(final String name) {
        setName(name);
    }

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
