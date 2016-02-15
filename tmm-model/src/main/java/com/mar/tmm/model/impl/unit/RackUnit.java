package com.mar.tmm.model.impl.unit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Describes a rack unit which cannot move nether rotate.
 */
@XmlRootElement(name = "RackUnit")
@XmlAccessorType(XmlAccessType.FIELD)
public class RackUnit extends AbstractUnit {

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
