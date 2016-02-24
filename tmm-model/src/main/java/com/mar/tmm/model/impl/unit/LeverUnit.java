package com.mar.tmm.model.impl.unit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes an lever unit.
 */
@XmlRootElement(name = "LeverUnit")
@XmlAccessorType(XmlAccessType.FIELD)
public class LeverUnit extends AbstractUnit {

    @XmlAttribute(name = "length")
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(final double length) {
        this.length = length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .appendSuper(super.toString())
            .append("length", length)
            .toString();
    }
}
