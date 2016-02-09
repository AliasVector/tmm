package com.mar.tmm.model.impl;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.unit.RackUnit;
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
    private RackUnit rack;

    @XmlElement
    private KinematicPair kinematicPair;

    @XmlElement
    @XmlElementWrapper(name = "Groups")
    private List<Group> groups;

    public DefaultMechanism() {
        rack = new RackUnit();
    }

    @Override
    public List<Group> getGroups() {
        return null;
    }

    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public RackUnit getRack() {
        return rack;
    }

    public void setRack(final RackUnit rack) {
        this.rack = rack;
    }

    public KinematicPair getKinematicPair() {
        return kinematicPair;
    }

    public void setKinematicPair(final KinematicPair kinematicPair) {
        this.kinematicPair = kinematicPair;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("name", name)
            .append("rack", rack)
            .append("kinematicPair", kinematicPair)
            .append("groups", groups)
            .toString();
    }
}
