package com.mar.tmm.model;

/**
 * Interface to describe the common behavior for mechanism group's element.
 */
public interface KinematicPair {
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
     * @return {@link Unit.Element} instance
     */
    Unit.Element getElement1();

    /**
     * Returns the connected element of some unit.
     *
     * @return {@link Unit.Element} instance
     */
    Unit.Element getElement2();

    /**
     * Enum with classes of kinematic pairs.
     */
    public static enum KinematicClass {
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
