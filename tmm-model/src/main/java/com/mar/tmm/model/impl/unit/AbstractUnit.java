package com.mar.tmm.model.impl.unit;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;

import com.google.common.collect.Lists;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes some abstract unit with common implementation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractUnit implements Unit {

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlAttribute(name = "name")
    private String name;

    @XmlAnyElement
    @XmlElementWrapper(name = "elements")
    private List<UnitElement> elements = Lists.newArrayList();

    public AbstractUnit() {
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
    public List<UnitElement> getElements() {
        return elements;
    }

    public void setElements(final List<UnitElement> elements) {
        this.elements = elements;
    }

    public void addElement(final UnitElement element) {
        if (element != null) {
            elements.add(element);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("id", id)
            .append("name", name)
            .append("elements", elements)
            .toString();
    }
}
