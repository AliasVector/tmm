package com.mar.tmm.model.impl.kinematicpair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes some abstract kinematic pair with common implementation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractKinematicPair implements KinematicPair {

    @XmlAttribute(name = "id")
    private String id = MechanismUtils.generateId();

    @XmlAttribute
    private String name;

    @XmlElement
    private Disposition disposition = new Disposition();

    @XmlAnyElement
    private Unit.Element element1;

    @XmlAnyElement
    private Unit.Element element2;

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
            .append("id", id)
            .append("name", name)
            .append("disposition", disposition)
            .append("element1.id", element1 == null ? null : element1.getId())
            .append("element2.id", element2 == null ? null : element2.getId())
            .toString();
    }
}
