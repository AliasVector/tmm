package com.mar.tmm.model.impl;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.group.FifthTypeGroup;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.group.FourthTypeGroup;
import com.mar.tmm.model.impl.group.SecondTypeGroup;
import com.mar.tmm.model.impl.group.ThirdTypeGroup;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import com.mar.tmm.util.KinematicUtils;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes default mechanism with rack unit and kinematic pair to connect the following groups.
 */
@XmlRootElement(name = "DefaultMechanism")
@XmlAccessorType(XmlAccessType.FIELD)
public class DefaultMechanism implements Mechanism {

    @XmlAttribute(name = "id")
    @XmlID
    private String id = MechanismUtils.generateId();

    @XmlAttribute(name = "name")
    private String name;

    @XmlElements({
            @XmlElement(name="RotationalPair", type = RotationalPair.class),
            @XmlElement(name="TranslationalPair", type = TranslationalPair.class)})
    private AbstractKinematicPair kinematicPair;

    @XmlElement(name = "Rack")
    private Unit rackUnit;

    @XmlElement(name = "LeverUnit")
    private Unit leverUnit;

    @XmlElementWrapper(name = "Groups")
    @XmlElements({
            @XmlElement(name="FirstTypeGroup", type = FirstTypeGroup.class),
            @XmlElement(name="SecondTypeGroup", type = SecondTypeGroup.class),
            @XmlElement(name="ThirdTypeGroup", type = ThirdTypeGroup.class),
            @XmlElement(name="FourthTypeGroup", type = FourthTypeGroup.class),
            @XmlElement(name="FifthTypeGroup", type = FifthTypeGroup.class)})
    private List<Group> groups = Lists.newArrayList();

    public DefaultMechanism() {
        rackUnit = new Unit();
        rackUnit.setFixed(true);

        leverUnit = new Unit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unit getRackUnit() {
        return rackUnit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unit getLeverUnit() {
        return leverUnit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void connectGroupToMechanism(final Group group, final AbstractKinematicPair groupPair) {
        if (groupPair == null) {
            throw new IllegalArgumentException("Cannot connect null kinematic pair to mechanism");
        }

        if (groupPair.getUnitElement1() != null && groupPair.getUnitElement2() != null) {
            throw new IllegalStateException("Kinematic pair doesn't have free element to connect");
        }

        if (leverUnit == null) {
            throw new IllegalStateException("Cannot connect kinematic pair to mechanism. Lever unit "
                + "was not initialized");
        }

        final UnitElement unitElement = KinematicUtils.createElementForUnit(leverUnit, leverUnit.getLength(), 0);
        if (groupPair.getUnitElement1() == null) {
            groupPair.setUnitElement1(unitElement);
        } else {
            groupPair.setUnitElement2(unitElement);
        }
        unitElement.setKinematicPair(groupPair);

        groups.add(group);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Group> getGroups() {
        return groups;
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
            .append("id", id)
            .append("name", name)
            .append("rackUnit", rackUnit)
            .append("leverUnit", leverUnit)
            .append("kinematicPair", kinematicPair)
            .append("groups", groups)
            .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultMechanism that = (DefaultMechanism) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
