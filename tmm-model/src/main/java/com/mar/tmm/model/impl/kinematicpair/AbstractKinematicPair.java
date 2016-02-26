package com.mar.tmm.model.impl.kinematicpair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes some abstract kinematic pair with common implementation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractKinematicPair implements KinematicPair {

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "Disposition")
    private Disposition disposition = new Disposition();

    @XmlIDREF
    @XmlElement(name = "Element1")
    private UnitElement unitElement1;

    @XmlIDREF
    @XmlElement(name = "Element2")
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
        this.unitElement2= unitElement2;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractKinematicPair that = (AbstractKinematicPair) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
