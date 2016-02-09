package com.mar.tmm.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Type of structure group.
 */
@XmlType(name = "GroupType")
@XmlEnum
public enum GroupType {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH
}
