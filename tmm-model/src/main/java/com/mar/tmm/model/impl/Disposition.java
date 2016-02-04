package com.mar.tmm.model.impl;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes the location of related element.
 */
public class Disposition {
    private double offsetX;
    private double offsetY;
    private double angle;

    public Disposition() {
    }

    public Disposition(final double offsetX, final double offsetY, final double angle) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.angle = angle;
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

    public double getAngle() {
        return angle;
    }

    public void setAngle(final double angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("offsetX", offsetX)
            .append("offsetY", offsetY)
            .append("angle", angle)
            .toString();
    }
}
