package com.mar.tmm.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.UnitElement;

/**
 * Interface to describe the common behavior for mechanism group's element.
 */
public interface KinematicPair extends EntityWithId {
    /**
     * Returns the disposition of the kinematic pair.
     *
     * @return {@link Disposition} instance
     */
    Disposition getDisposition();

    /**
     * Returns the name of the kinematic pair.
     *
     * @return string with the name
     */
    String getName();

    /**
     * Returns the class of this kinematic pair.
     *
     * @return {@link KinematicPair.KinematicClass} instance
     */
    KinematicClass getKinematicClass();

    /**
     * Returns the connected element of some unit.
     *
     * @return {@link UnitElement} instance
     */
    UnitElement getUnitElement1();

    /**
     * Sets element1
     *
     * @param element1 element to be set as element 1
     */
    void setUnitElement1(UnitElement element1);

    /**
     * Returns the connected element of some unit.
     *
     * @return {@link UnitElement} instance
     */
    UnitElement getUnitElement2();

    /**
     * Sets element2
     *
     * @param element2 element to be set as element 2
     */
    void setUnitElement2(UnitElement element2);

    /**
     * Enum with classes of kinematic pairs.
     */
    @XmlType(name = "KinematicClass")
    @XmlEnum
    enum KinematicClass {
        P4(1),
        P5(2);

        int limitataion;

        KinematicClass(final int limitation) {
            this.limitataion = limitation;
        }

        public int getLimitataion() {
            return limitataion;
        }
    }
}
