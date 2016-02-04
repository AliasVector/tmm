package com.mar.tmm.model.impl.unit;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes an lever unit.
 */
public class LeverUnit extends AbstractUnit {

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
