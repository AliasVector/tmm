package com.mar.tmm.model.impl;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes an slide unit which can move back and forward.
 */
public class SlideUnit extends AbstractUnit {

    private double length;
    private double height;

    public double getLength() {
        return length;
    }

    public void setLength(final double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .appendSuper(super.toString())
            .append("length", length)
            .append("height", height)
            .toString();
    }
}
