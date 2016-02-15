package com.mar.tmm.model.impl.kinematicpair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.Disposition;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes some abstract kinematic pair with common implementation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractKinematicPair implements KinematicPair {

    @XmlAttribute
    private String name;

    @XmlElement
    private Disposition disposition = new Disposition();

    @XmlTransient
    private Unit.Element element1;

    @XmlTransient
    private Unit.Element element2;

    public AbstractKinematicPair() {
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
    public Unit.Element getElement1() {
        return element1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setElement1(final Unit.Element element1) {
        this.element1 = element1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unit.Element getElement2() {
        return element2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setElement2(final Unit.Element element2) {
        this.element2 = element2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("name", name)
            .append("disposition", disposition)
            .append("element1", element1)
            .append("element2", element2)
            .toString();
    }
}
