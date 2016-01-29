package com.mar.tmm.model.impl;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes an slide unit which can move back and forward.
 */
public class SlideUnit extends AbstractUnit {

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .appendSuper(super.toString())
            .toString();
    }
}
