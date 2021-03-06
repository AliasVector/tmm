package com.mar.tmm.model.impl.kinematicpair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes rotational kinematic pair.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RotationalPair extends AbstractKinematicPair {

    @XmlElement(name = "KinematicClass")
    private final KinematicClass kinematicClass = KinematicClass.P4;

    @XmlAttribute(name = "angle")
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
     * Returns the angle between elements.
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
