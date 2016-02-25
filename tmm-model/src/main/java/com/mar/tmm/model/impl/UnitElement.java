package com.mar.tmm.model.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

import com.mar.tmm.model.EntityWithId;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Class for specifying unit elements.
 */
@XmlRootElement(name = "DefaultElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnitElement implements EntityWithId {

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlIDREF
    private Unit unit;

    @XmlElement(name = "disposition")
    private Disposition disposition;

    @XmlIDREF
    @XmlElements({@XmlElement(type = RotationalPair.class), @XmlElement(type = TranslationalPair.class)})
    private KinematicPair kinematicPair;

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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(final Disposition disposition) {
        this.disposition = disposition;
    }

    public KinematicPair getKinematicPair() {
        return kinematicPair;
    }

    public void setKinematicPair(final KinematicPair kinematicPair) {
        this.kinematicPair = kinematicPair;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("id", id)
            .append("unit.id", unit == null ? "" : unit.getId())
            .append("disposition", disposition)
            .append("kinematicPair.id", kinematicPair == null ? "" : kinematicPair.getId())
            .toString();
    }
}
