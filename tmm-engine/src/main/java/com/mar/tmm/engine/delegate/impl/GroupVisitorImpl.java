package com.mar.tmm.engine.delegate.impl;

import java.util.List;

import com.mar.tmm.engine.delegate.GroupVisitor;
import com.mar.tmm.engine.delegate.KinematicPairVisitor;
import com.mar.tmm.engine.delegate.UnitVisitor;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;

/**
 * Implementation of {@link GroupVisitor}.
 */
public class GroupVisitorImpl implements GroupVisitor {

    private KinematicPairVisitor kinematicPairVisitor = new KinematicPairVisitorImpl();
    private UnitVisitor unitVisitor = new UnitVisitorImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KinematicPair> calculate(final Group group, final KinematicPair startPair) {
        // ToDo implement: recalculates unit, internal pair, external pairs regarding the start pair which was changed




        return null;
    }
}
