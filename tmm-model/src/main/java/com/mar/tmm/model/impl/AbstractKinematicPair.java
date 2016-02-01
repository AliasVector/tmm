package com.mar.tmm.model.impl;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes some abstract kinematic pair with common implementation.
 */
public abstract class AbstractKinematicPair implements KinematicPair {
    private String name;
    private Disposition disposition = new Disposition();
    private Unit.Element element1;
    private Unit.Element element2;

    public AbstractKinematicPair() {
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

    @Override
    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(final Disposition disposition) {
        this.disposition = disposition;
    }

    @Override
    public Unit.Element getElement1() {
        return element1;
    }

    public void setElement1(final Unit.Element element1) {
        this.element1 = element1;
    }

    @Override
    public Unit.Element getElement2() {
        return element2;
    }

    public void setElement2(final Unit.Element element2) {
        this.element2 = element2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("name", name)
            .append("disposition", disposition)
            .append("element1", element1)
            .append("element2", element2)
            .toString();
    }
}
