package com.mar.tmm.util;

import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.model.impl.group.AbstractGroup;
import com.mar.tmm.model.impl.group.FifthTypeGroup;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.group.FourthTypeGroup;
import com.mar.tmm.model.impl.group.SecondTypeGroup;
import com.mar.tmm.model.impl.group.ThirdTypeGroup;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import com.mar.tmm.model.impl.unit.LeverUnit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for tmm groups.
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

        LOGGER.trace("Start creating the structure group of the first type...");

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Group cannot have empty name");
        }

        final FirstTypeGroup result = fillThreePairsGroup(new FirstTypeGroup(name),
            new RotationalPair(externalPair1Name), new RotationalPair(externalPair2Name),
            new RotationalPair(internalPairName), leverUnit1Name, leverUnit2Name);

        LOGGER.debug("Finished creating the structure group of the first type: {}", result);
        return result;
    }

    /**
     * Creates group of the {@link com.mar.tmm.model.GroupType#SECOND}.
     *
     * @param name              name of the group
     * @param externalPair1Name name of the first external pair
     * @param externalPair2Name name of the second external pair
     * @param internalPairName  name of the internal pair
     * @param leverUnit1Name    name of the lever unit between the first external pair and internal pair
     * @param leverUnit2Name    name of the lever unit between the second external pair and internal pair
     *
     * @return instance of the {@link SecondTypeGroup} class
     */
    public static SecondTypeGroup createSecondTypeGroup(final String name, final String externalPair1Name,
        final String externalPair2Name, final String internalPairName, final String leverUnit1Name,
        final String leverUnit2Name) {

        LOGGER.trace("Start creating the structure group of the second type...");

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Group cannot have empty name");
        }

        final SecondTypeGroup result = fillThreePairsGroup(new SecondTypeGroup(name),
            new RotationalPair(externalPair1Name), new TranslationalPair(externalPair2Name),
            new RotationalPair(internalPairName), leverUnit1Name, leverUnit2Name);

        LOGGER.debug("Finished creating the structure group of the second type: {}", result);
        return result;
    }

    /**
     * Creates group of the {@link com.mar.tmm.model.GroupType#THIRD}.
     *
     * @param name              name of the group
     * @param externalPair1Name name of the first external pair
     * @param externalPair2Name name of the second external pair
     * @param internalPairName  name of the internal pair
     * @param leverUnit1Name    name of the lever unit between the first external pair and internal pair
     * @param leverUnit2Name    name of the lever unit between the second external pair and internal pair
     *
     * @return instance of the {@link ThirdTypeGroup} class
     */
    public static ThirdTypeGroup createThirdTypeGroup(final String name, final String externalPair1Name,
        final String externalPair2Name, final String internalPairName, final String leverUnit1Name,
        final String leverUnit2Name) {

        LOGGER.trace("Start creating the structure group of the third type...");

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Group cannot have empty name");
        }

        final ThirdTypeGroup result = fillThreePairsGroup(new ThirdTypeGroup(name),
            new RotationalPair(externalPair1Name), new RotationalPair(externalPair2Name),
            new TranslationalPair(internalPairName), leverUnit1Name, leverUnit2Name);

        LOGGER.debug("Finished creating the structure group of the third type: {}", result);
        return result;
    }

    /**
     * Creates group of the {@link com.mar.tmm.model.GroupType#FOURTH}.
     *
     * @param name              name of the group
     * @param externalPair1Name name of the first external pair
     * @param externalPair2Name name of the second external pair
     * @param internalPairName  name of the internal pair
     * @param leverUnit1Name    name of the lever unit between the first external pair and internal pair
     * @param leverUnit2Name    name of the lever unit between the second external pair and internal pair
     *
     * @return instance of the {@link FourthTypeGroup} class
     */
    public static FourthTypeGroup createFourthTypeGroup(final String name, final String externalPair1Name,
        final String externalPair2Name, final String internalPairName, final String leverUnit1Name,
        final String leverUnit2Name) {

        LOGGER.trace("Start creating the structure group of the fourth type...");

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Group cannot have empty name");
        }

        final FourthTypeGroup result = fillThreePairsGroup(new FourthTypeGroup(name),
            new TranslationalPair(externalPair1Name), new RotationalPair(externalPair2Name),
            new TranslationalPair(internalPairName), leverUnit1Name, leverUnit2Name);

        LOGGER.debug("Finished creating the structure group of the fourth type: {}", result);
        return result;
    }

    /**
     * Creates group of the {@link com.mar.tmm.model.GroupType#FIFTH}.
     *
     * @param name              name of the group
     * @param externalPair1Name name of the first external pair
     * @param externalPair2Name name of the second external pair
     * @param internalPairName  name of the internal pair
     * @param leverUnit1Name    name of the lever unit between the first external pair and internal pair
     * @param leverUnit2Name    name of the lever unit between the second external pair and internal pair
     *
     * @return instance of the {@link FifthTypeGroup} class
     */
    public static FifthTypeGroup createFifthTypeGroup(final String name, final String externalPair1Name,
        final String externalPair2Name, final String internalPairName, final String leverUnit1Name,
        final String leverUnit2Name) {

        LOGGER.trace("Start creating the structure group of the fourth type...");

        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Group cannot have empty name");
        }

        final FifthTypeGroup result = fillThreePairsGroup(new FifthTypeGroup(name),
            new RotationalPair(externalPair1Name), new TranslationalPair(externalPair2Name),
            new TranslationalPair(internalPairName), leverUnit1Name, leverUnit2Name);

        LOGGER.debug("Finished creating the structure group of the fourth type: {}", result);
        return result;
    }

    private static <T extends AbstractGroup> T fillThreePairsGroup(final T group,
        final AbstractKinematicPair firstExternalPair, final AbstractKinematicPair secondExternalPair,
        final AbstractKinematicPair internalPair, final String leverUnit1Name, final String leverUnit2Name) {

        group.setExternalPair1(firstExternalPair);
        group.setExternalPair2(secondExternalPair);

        group.setInternalPair(internalPair);

        final LeverUnit unit1 = createAndConnectLeverUnit(leverUnit1Name, firstExternalPair, internalPair);
        group.setLeverUnit1(unit1);

        final LeverUnit unit2 = createAndConnectLeverUnit(leverUnit2Name, internalPair, secondExternalPair);
        group.setLeverUnit2(unit2);

        return group;
    }

    private static LeverUnit createAndConnectLeverUnit(final String unitName, final AbstractKinematicPair pair1,
        final AbstractKinematicPair pair2) {

        final LeverUnit unit = new LeverUnit();
        unit.setName(unitName);
        unit.setLength(DEFAULT_LEVER_LENGTH);

        final UnitElement firstUnitElement = KinematicUtils.createElementForUnit(unit, 0, 0);
        unit.getElements().add(firstUnitElement);
        pair1.setUnitElement2(firstUnitElement);
        firstUnitElement.setKinematicPair(pair1);

        final UnitElement secondUnitElement = KinematicUtils.createElementForUnit(unit, unit.getLength(), 0);
        unit.getElements().add(secondUnitElement);
        pair2.setUnitElement1(secondUnitElement);
        secondUnitElement.setKinematicPair(pair2);

        return unit;
    }
}
