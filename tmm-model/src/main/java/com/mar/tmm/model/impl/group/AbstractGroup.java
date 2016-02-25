package com.mar.tmm.model.impl.group;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;
import com.mar.tmm.util.KinematicUtils;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Abstract group functionality.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractGroup implements Group {
    private static final int UNITS_RATE = 3;
    private static final int P5_RATE = 2;

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlAttribute
    private String name;

    @XmlElement(name = "InternalPair")
    private AbstractKinematicPair internalPair;

    @XmlElement(name = "ExternalPair1")
    private AbstractKinematicPair externalPair1;

    @XmlElement(name = "ExternalPair2")
    private AbstractKinematicPair externalPair2;

    @XmlElement(name = "Unit1")
    private Unit unit1;

    @XmlElement(name = "Unit2")
    private Unit unit2;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Unit getUnit1() {
        return unit1;
    }

    public void setUnit1(final Unit unit1) {
        this.unit1 = unit1;
    }

    public Unit getUnit2() {
        return unit2;
    }

    public void setUnit2(final Unit unit2) {
        this.unit2 = unit2;
    }

    public AbstractKinematicPair getInternalPair() {
        return internalPair;
    }

    public void setInternalPair(final AbstractKinematicPair internalPair) {
        this.internalPair = internalPair;
    }

    public AbstractKinematicPair getExternalPair1() {
        return externalPair1;
    }

    public void setExternalPair1(final AbstractKinematicPair externalPair1) {
        this.externalPair1 = externalPair1;
    }

    public AbstractKinematicPair getExternalPair2() {
        return externalPair2;
    }

    public void setExternalPair2(final AbstractKinematicPair externalPair2) {
        this.externalPair2 = externalPair2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateFreedomDegrees() {
        final int amountOfUnits = 2;
        final int amountOfP4Pairs = KinematicUtils.calculateKinematicPairsOfClass(KinematicPair.KinematicClass.P4,
            externalPair1, externalPair2, internalPair);
        final int amountOfP5Pairs = KinematicUtils.calculateKinematicPairsOfClass(KinematicPair.KinematicClass.P5,
            externalPair1, externalPair2, internalPair);

        return UNITS_RATE * amountOfUnits - P5_RATE * amountOfP5Pairs - amountOfP4Pairs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("id", id)
            .append("name", name)
            .append("unit1", unit1)
            .append("unit2", unit2)
            .append("internalPair", internalPair)
            .append("externalPair1", externalPair1)
            .append("externalPair2", externalPair2)
            .toString();
    }
}
