package com.mar.tmm.model.impl.group;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.mar.tmm.model.GroupType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Class of the group of the second type. This group contains one rotational external pair, one rotational internal
 * pair and one translational external pair. These pairs are connected with levers.
 */
@XmlRootElement(name = "SecondTypeGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThirdTypeGroup extends AbstractGroup {
    private static final GroupType TYPE = GroupType.THIRD;

    public ThirdTypeGroup() {
    }

    public ThirdTypeGroup(final String name) {
        setName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupType getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .appendSuper(super.toString())
            .toString();
    }
}
