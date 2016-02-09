package com.mar.tmm.model.impl.unit;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.google.common.collect.Lists;
import com.mar.tmm.model.Unit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes some abstract unit with common implementation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractUnit implements Unit {
    @XmlAttribute(name = "name")
    private String name;

    @XmlElement
    @XmlElementWrapper(name = "elements")
    private List<Element> elements = Lists.newArrayList();

    public AbstractUnit() {
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
    public List<Element> getElements() {
        return elements;
    }

    public void setElements(final List<Element> elements) {
        this.elements = elements;
    }

    public void addElement(final Element element) {
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
            .append("name", name)
            .append("elements", elements)
            .toString();
    }
}
