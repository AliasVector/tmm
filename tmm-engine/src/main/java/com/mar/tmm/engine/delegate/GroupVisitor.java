package com.mar.tmm.engine.delegate;

import java.util.List;

import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;

/**
 * Recalculates the state of items in the group.
 */
public interface GroupVisitor {

    /**
     * Recalculates the internal state of group items (dispositions, angles) regarding by the given start pair change.
     *
     * @param startPair pair which is already recalculated
     *
     * @return list of external pairs of this group, which can be start pairs for other groups.
     */
    List<KinematicPair> calculate(Group group, KinematicPair startPair);

}
