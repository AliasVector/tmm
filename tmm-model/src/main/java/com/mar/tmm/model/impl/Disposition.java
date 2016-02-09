package com.mar.tmm.model.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes the location of related element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Disposition {

    @XmlAttribute(name = "offsetX")
    private double offsetX;

    @XmlAttribute(name = "offsetY")
    private double offsetY;

    public Disposition() {
    }

    public Disposition(final double offsetX, final double offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(final double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(final double offsetY) {
        this.offsetY = offsetY;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("offsetX", offsetX)
            .append("offsetY", offsetY)
            .toString();
    }
}
