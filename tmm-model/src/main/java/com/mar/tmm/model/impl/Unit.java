package com.mar.tmm.model.impl;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;

import com.google.common.collect.Lists;
import com.mar.tmm.model.EntityWithId;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Interface to describe the common behavior for mechanism group's unit.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit implements EntityWithId {
    public static final int DEFAULT_LENGTH = 200;

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "Disposition")
    private Disposition disposition = new Disposition(0, 0);

    @XmlAttribute(name = "length")
    private int length = DEFAULT_LENGTH;

    @XmlElementWrapper(name = "Elements")
    @XmlElement(name = "Element")
    private List<UnitElement> elements = Lists.newArrayList();

    @XmlAttribute(name = "fixed")
    private boolean fixed;

    @Override
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(final Disposition disposition) {
        this.disposition = disposition;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public List<UnitElement> getElements() {
        return elements;
    }

    public void setElements(final List<UnitElement> elements) {
        this.elements = elements;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(final boolean fixed) {
        this.fixed = fixed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .append("disposition", disposition)
            .append("length", length)
            .append("elements", elements)
            .append("fixed", fixed)
            .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (length != unit.length) return false;
        if (fixed != unit.fixed) return false;
        if (id != null ? !id.equals(unit.id) : unit.id != null) return false;
        return !(name != null ? !name.equals(unit.name) : unit.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (fixed ? 1 : 0);
        return result;
    }
}
