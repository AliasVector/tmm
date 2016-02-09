package com.mar.tmm.model.impl.unit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.Disposition;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Implementation of {@link com.mar.tmm.model.Unit.Element} interace.
 */
@XmlType(name = "DefaultElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class DefaultElement implements Unit.Element {

    @XmlElement
    private Unit unit;

    @XmlElement(name = "disposition")
    private Disposition disposition;

    @XmlElement
    private KinematicPair kinematicPair;

    @Override
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }

    @Override
    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(final Disposition disposition) {
        this.disposition = disposition;
    }

    @Override
    public KinematicPair getKinematicPair() {
        return kinematicPair;
    }

    @Override
    public void setKinematicPair(final KinematicPair kinematicPair) {
        this.kinematicPair = kinematicPair;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("unit", unit)
            .append("disposition", disposition)
            .append("kinematicPair", kinematicPair)
            .toString();
    }
}
