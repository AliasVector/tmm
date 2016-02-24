package com.mar.tmm.model.impl.kinematicpair;


import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

/**
 * Describes some abstract kinematic pair with common implementation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractKinematicPair implements KinematicPair {

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlAttribute
    private String name;

    @XmlElement
    private Disposition disposition = new Disposition();

    @XmlIDREF
    private UnitElement unitElement1;

    @XmlIDREF
    private UnitElement unitElement2;

    public AbstractKinematicPair() {
    }

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(final Disposition disposition) {
        this.disposition = disposition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitElement getUnitElement1() {
        return unitElement1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUnitElement1(final UnitElement unitElement1) {
        this.unitElement1 = unitElement1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitElement getUnitElement2() {
        return unitElement2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUnitElement2(final UnitElement unitElement2) {
        this.unitElement2 = unitElement2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("disposition", disposition)
                .append("unitElement1", unitElement1)
                .append("unitElement2", unitElement2)
                .toString();
    }
}
