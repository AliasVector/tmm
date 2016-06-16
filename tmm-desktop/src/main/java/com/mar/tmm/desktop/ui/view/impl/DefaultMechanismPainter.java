package com.mar.tmm.desktop.ui.view.impl;

import com.mar.tmm.desktop.ui.view.KinematicPairPainter;
import com.mar.tmm.desktop.ui.view.UnitPainter;
import com.mar.tmm.desktop.ui.view.MechanismPainter;
import com.mar.tmm.desktop.ui.view.nodes.AbstractNode;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.Unit;
import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.piccolo2d.PCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author roman
 */
public class DefaultMechanismPainter implements MechanismPainter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMechanismPainter.class);

    private final Set<Unit> paintedUnits = new HashSet<>();
    private final Set<KinematicPair> paintedPairs = new HashSet<>();
    
    private final UnitPainter unitPainter = new DefaultUnitPainter();
    private final KinematicPairPainter kinematicPairPainter = new DefaultKinematicPairPainter();

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(final Mechanism mechanism, final PCanvas canvas) {
        if (mechanism == null) {
            LOGGER.debug("Cannot paint mechanism which is null");
            return;
        }

        clearCanvas(canvas);
        paintUnit(mechanism.getRackUnit(), 0, canvas);

        paintedUnits.clear();
        paintedPairs.clear();
    }

    private void clearCanvas(final PCanvas canvas) {
        canvas.getLayer().removeAllChildren();
    }

    private void paintUnit(final Unit unit, final double currentAngle, final PCanvas canvas) {
        if (paintedUnits.contains(unit)) {
            return;
        }
            
        final AbstractNode node = unitPainter.paint(unit, currentAngle);
        canvas.getLayer().addChild(node);
        
        paintedUnits.add(unit);
        // Paint pairs
        final List<KinematicPair> unitPairs = new ArrayList<>();
        unit.getElements().forEach((final UnitElement element) -> {
            if (element.getKinematicPair() != null) {
                unitPairs.add(element.getKinematicPair());
            }
        });
        
        unitPairs.forEach((final KinematicPair pair) -> {
            paintKinematicPair(pair, currentAngle, canvas);
        });
    }

    private <T extends KinematicPair> void paintKinematicPair(final T pair, final double currentAngle, 
            final PCanvas canvas) {
        
        if (paintedPairs.contains(pair)) {
            return;
        }
        
        final AbstractNode node = kinematicPairPainter.paint(pair, currentAngle);
        canvas.getLayer().addChild(node);
        
        paintedPairs.add(pair);
        
        double angle = currentAngle;
        if (pair instanceof RotationalPair) {
            angle = angle + ((RotationalPair) pair).getAngle();
        }
        
        // Paint units
        paintUnit(pair.getUnitElement1().getUnit(), angle, canvas);
        paintUnit(pair.getUnitElement2().getUnit(), angle, canvas);
    }
}
