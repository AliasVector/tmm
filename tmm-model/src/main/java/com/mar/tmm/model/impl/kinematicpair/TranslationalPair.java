package com.mar.tmm.model.impl.kinematicpair;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Describes translational kinematic pair.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TranslationalPair extends AbstractKinematicPair {

    @XmlElement
    private final KinematicClass kinematicClass = KinematicClass.P4;

    @XmlAttribute(name = "movement")
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
     * Returns the movement between elements.
     *
     * @return double value of movement
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
