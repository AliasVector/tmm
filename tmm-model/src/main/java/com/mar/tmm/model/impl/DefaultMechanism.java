package com.mar.tmm.model.impl;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;
import com.mar.tmm.model.impl.unit.LeverUnit;
import com.mar.tmm.model.impl.unit.RackUnit;
import com.mar.tmm.util.KinematicUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes default mechanism with rack unit and kinematic pair to connect the following groups.
 */
@XmlRootElement(name = "DefaultMechanism")
@XmlAccessorType(XmlAccessType.FIELD)
public class DefaultMechanism implements Mechanism {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "Rack")
    private RackUnit rackUnit;

    @XmlElement(name = "LeverUnit")
    private LeverUnit leverUnit;

    @XmlElement
    private AbstractKinematicPair kinematicPair;

    @XmlAnyElement
    @XmlElementWrapper(name = "Groups")
    private List<Group> groups = Lists.newArrayList();

    public DefaultMechanism() {
        rackUnit = new RackUnit();
        leverUnit = new LeverUnit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RackUnit getRackUnit() {
        return rackUnit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeverUnit getLeverUnit() {
        return leverUnit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void connectGroupToMechanism(final Group group, final KinematicPair groupPair) {
        if (groupPair == null) {
            throw new IllegalArgumentException("Cannot connect null kinematic pair to mechanism");
        }

        if (groupPair.getElement1() != null && groupPair.getElement2() != null) {
            throw new IllegalStateException("Kinematic pair doesn't have free element to connect");
        }

        if (leverUnit == null) {
            throw new IllegalStateException("Cannot connect kinematic pair to mechanism. Lever unit "
                + "was not initialized");
        }

        final Unit.Element element = KinematicUtils.createElementForUnit(leverUnit, leverUnit.getLength(), 0);
        if (groupPair.getElement1() == null) {
            groupPair.setElement1(element);
        } else {
            groupPair.setElement2(element);
        }
        element.setKinematicPair(groupPair);

        groups.add(group);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Group> getGroups() {
        return null;
    }

    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    /**
     * {@inheritDoc}
     */
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
    public KinematicPair getKinematicPair() {
        return kinematicPair;
    }

    public void setKinematicPair(final AbstractKinematicPair kinematicPair) {
        this.kinematicPair = kinematicPair;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("name", name)
            .append("rackUnit", rackUnit)
            .append("leverUnit", leverUnit)
            .append("kinematicPair", kinematicPair)
            .append("groups", groups)
            .toString();
    }
}
