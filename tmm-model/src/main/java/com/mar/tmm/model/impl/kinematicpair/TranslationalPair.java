package com.mar.tmm.model.impl.kinematicpair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes translational kinematic pair.
 */
@XmlType(name = "TranslationalPair")
@XmlAccessorType(XmlAccessType.FIELD)
public class TranslationalPair extends AbstractKinematicPair {

    @XmlElement
    private final KinematicClass kinematicClass = KinematicClass.P4;

    @XmlElement(name = "movement")
    private double movement = 0;

    public TranslationalPair() {
    }

    public TranslationalPair(final String name) {
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
    public double getMovement() {
        return movement;
    }

    public void setMovement(final double movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .appendSuper(super.toString())
            .append("kinematicClass", kinematicClass)
            .append("movement", movement)
            .toString();
    }
}
