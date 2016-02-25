package com.mar.tmm.model.impl.group;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.mar.tmm.model.GroupType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Class of the group of the first type. This group contains two external rotational pair and one internal rotational
 * pair. These pairs are connected with levers.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FirstTypeGroup extends AbstractGroup {
    private static final GroupType TYPE = GroupType.FIRST;

    public FirstTypeGroup() {
    }

    public FirstTypeGroup(final String name) {
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
