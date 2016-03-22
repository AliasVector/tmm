package com.mar.tmm.engine.impl;

import java.util.List;

import com.mar.tmm.engine.Engine;
import com.mar.tmm.engine.delegate.GroupVisitor;
import com.mar.tmm.engine.delegate.impl.GroupVisitorImpl;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Default engine implementation.
 */
public class DefaultEngine implements Engine {

    private GroupVisitor groupVisitor = new GroupVisitorImpl();

    @Override
    public Mechanism calculate(final Mechanism mechanism, final KinematicPair startPair, final double change) {
        // First apply change to the given kinematic pair

        // Now check if this pair belongs to some group or mechanism
        if (startPair.equals(mechanism.getKinematicPair())) {
            // ToDo recalculate the position of mechanism unit and the following pair

            // Now calculate groups
            final KinematicPair groupPair = null;
            calculateGroupsRecursively(mechanism, groupPair);
        } else {
            calculateGroupsRecursively(mechanism, startPair);
        }

        return mechanism;
    }

    private Group getGroupWithExternalPair(final Mechanism mechanism, final KinematicPair pair) {
        if (pair == null) {
            return null;
        }

        final List<Group> groups = mechanism.getGroups();
        return groups.stream().filter(group ->
            pair.equals(group.getExternalPair1()) || pair.equals(group.getExternalPair2())).findFirst().orElse(null);

    }

    private void calculateGroupsRecursively(final Mechanism mechanism, final KinematicPair startPair) {
        if (startPair == null) {
            // Nothing to do
            return;
        }

        // Find the group where the given startPair is an external pair
        final Group group = getGroupWithExternalPair(mechanism, startPair);
        if (group == null) {
            // Nothing to do
            return;
        }

        calculateGroupsRecursively(mechanism, groupVisitor.calculate(group, startPair));
    }

    private void calculateGroupsRecursively(final Mechanism mechanism, final List<KinematicPair> startPairs) {
        if (CollectionUtils.isEmpty(startPairs)) {
            // Nothing to do
            return;
        }

        for (final KinematicPair startPair : startPairs) {
            calculateGroupsRecursively(mechanism, startPair);
        }
    }
}
