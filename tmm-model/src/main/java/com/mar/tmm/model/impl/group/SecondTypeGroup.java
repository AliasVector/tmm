package com.mar.tmm.model.impl.group;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.mar.tmm.model.GroupType;

/**
 * Class of the group of the second type. This group contains one rotational external pair, one rotational internal
 * pair and one translational external pair. These pairs are connected with levers.
 */
@XmlRootElement(name = "SecondTypeGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecondTypeGroup extends AbstractGroup {
    private static final GroupType TYPE = GroupType.SECOND;

    public SecondTypeGroup() {
    }

    public SecondTypeGroup(final String name) {
        setName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupType getType() {
        return TYPE;
    }
}
