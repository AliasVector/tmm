package com.mar.tmm.util;

import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.DefaultMechanism;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for tmm mechanisms.
 */
public final class MechanismUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MechanismUtils.class);

    private MechanismUtils() {
    }

    /**
     * Creates a new mechanism with rotation kinematic pair, connects it to rack mount with element1  of kinematic
     * pair. To connect rack unit with rotation kinematic pair creates a new element for rack unit with disposition
     * x=0 and y=0.
     *
     * @param name     name of the mechanism
     * @param pairName name of rotation kinematic pair
     * @param rackName name of the rack unit in mechanism
     *
     * @return {@link DefaultMechanism} instance
     */
    public static DefaultMechanism createMechanismWithRotationKinematicPair(final String name, final String pairName,
        final String rackName, final String leverName) {

        LOGGER.trace("Start creating mechanism with rotation kinematic pair...");

        final DefaultMechanism result = createMechanism(name, new RotationalPair(), pairName, rackName, leverName);

        LOGGER.debug("Finished creating mechanism with rotation kinematic pair: {}", result);
        return result;
    }

    /**
     * Creates a new mechanism with translational kinematic pair, connects it to rack mount with element1 of kinematic
     * pair. To connect rack unit with translational kinematic pair creates a new element for rack unit with disposition
     * x=0 and y=0.
     *
     * @param name     name of the mechanism
     * @param pairName name of translational kinematic pair
     * @param rackName name of the rack unit in mechanism
     *
     * @return {@link DefaultMechanism} instance
     */
    public static DefaultMechanism createMechanismWithTranslationalKinematicPair(final String name,
        final String pairName, final String rackName, final String leverName) {

        LOGGER.trace("Start creating mechanism with translational kinematic pair...");

        final DefaultMechanism result = createMechanism(name, new TranslationalPair(), pairName, rackName, leverName);

        LOGGER.debug("Finished creating mechanism with translational kinematic pair: {}", result);
        return result;
    }

    private static DefaultMechanism createMechanism(final String name, final AbstractKinematicPair pair,
        final String pairName, final String rackName, final String leverName) {

        final DefaultMechanism result = new DefaultMechanism();
        result.setName(name);
        result.getRackUnit().setName(rackName);

        pair.setName(pairName);

        final Unit.Element rack = KinematicUtils.createElementForUnit(result.getRackUnit(), 0, 0);
        rack.setKinematicPair(pair);
        pair.setElement1(rack);

        final Unit.Element lever = KinematicUtils.createElementForUnit(result.getLeverUnit(), 0, 0);
        lever.setKinematicPair(pair);
        pair.setElement2(lever);

        return result;
    }
}
