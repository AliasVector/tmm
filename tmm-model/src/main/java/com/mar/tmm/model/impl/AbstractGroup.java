package com.mar.tmm.model.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Abstract group functionality.
 */
public abstract class AbstractGroup implements Group {
    private String name;
    private List<KinematicPair> kinematicPairs = Lists.newArrayList();

    @Override
    public String getName() {
        return null;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KinematicPair> getExternalKinematicPairs() {
        return kinematicPairs;
    }

    public void setKinematicPairs(final List<KinematicPair> kinematicPairs) {
        this.kinematicPairs = kinematicPairs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("name", name)
            .append("kinematicPairs", kinematicPairs)
            .toString();
    }
}
