package com.mar.tmm.model.impl;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mar.tmm.model.EntityWithId;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.group.SecondTypeGroup;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import com.mar.tmm.model.impl.unit.LeverUnit;
import com.mar.tmm.model.impl.unit.RackUnit;
import com.mar.tmm.model.impl.unit.SlideUnit;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Class for unit element's definition.
 */
@XmlRootElement(name = "Element")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnitElement implements EntityWithId {

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlElement(name = "disposition")
    private Disposition disposition;

    @XmlTransient
//    @XmlIDREF
//    @XmlElements({@XmlElement(type = LeverUnit.class), @XmlElement(type = RackUnit.class),
//            @XmlElement(type = SlideUnit.class)})
    private Unit unit;

    @XmlTransient
//    @XmlIDREF
//    @XmlElements({@XmlElement(type = RotationalPair.class), @XmlElement(type = TranslationalPair.class)})
    private KinematicPair kinematicPair;

    public void afterUnmarshal(final Unmarshaller unmarshaller, final Object parent) {
        if (parent instanceof Unit) {
            this.unit = (Unit) parent;
        } else if (parent instanceof KinematicPair) {
            this.kinematicPair = (KinematicPair) parent;
        }
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
