package com.mar.tmm.util;

import java.util.Collections;

import com.google.common.collect.Lists;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.unit.LeverUnit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for tmm elements.
 */
public final class GroupUtils {
    public static final int DEFAULT_LEVER_LENGTH = 20;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupUtils.class);

    private GroupUtils() {
    }

    /**
     * Creates group of the {@link com.mar.tmm.model.GroupType#FIRST}.
     *
     * @param name              name of the group
     * @param externalPair1Name name of the first external pair
     * @param externalPair2Name name of the second external pair
     * @param internalPairName  name of the internal pair
     * @param leverUnit1Name    name of the lever unit between the first external pair and internal pair
     * @param leverUnit2Name    name of the lever unit between the second external pair and internal pair
     *
     * @return instance of the {@link FirstTypeGroup} class
     */
    public static FirstTypeGroup createFirstTypeGroup(final String name, final String externalPair1Name,
        final String externalPair2Name, final String internalPairName, final String leverUnit1Name,
        final String leverUnit2Name) {

        LOGGER.trace("Start creating first type of structure group...");

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Group cannot have empty name");
        }

        final FirstTypeGroup result = new FirstTypeGroup();
        result.setName(name);

        final RotationalPair firstExternalPair = new RotationalPair();
        firstExternalPair.setName(externalPair1Name);

        final RotationalPair secondExternalPair = new RotationalPair();
        secondExternalPair.setName(externalPair2Name);

        final RotationalPair internalPair = new RotationalPair();
        internalPair.setName(internalPairName);

        createAndConnectUnit(leverUnit1Name, firstExternalPair, internalPair);
        createAndConnectUnit(leverUnit2Name, internalPair, secondExternalPair);

        result.setExternalKinematicPairs(Collections.unmodifiableList(
            Lists.newArrayList(firstExternalPair, secondExternalPair)));

        LOGGER.debug("Finished creating first type of structure group: {}", result);
        return result;
    }

    private static void createAndConnectUnit(final String unitName, final RotationalPair pair1,
        final RotationalPair pair2) {

        final LeverUnit unit = new LeverUnit();
        unit.setName(unitName);
        unit.setLength(DEFAULT_LEVER_LENGTH);

        final Unit.Element firstUnitElement = KinematicUtils.createElementForUnit(unit, 0, 0, 0);
        unit.getElements().add(firstUnitElement);
        pair1.setElement2(firstUnitElement);

        final Unit.Element secondUnitElement = KinematicUtils.createElementForUnit(unit, unit.getLength(), 0, 0);
        unit.getElements().add(secondUnitElement);
        pair2.setElement1(secondUnitElement);
    }
}
