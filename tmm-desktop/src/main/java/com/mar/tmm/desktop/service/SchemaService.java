package com.mar.tmm.desktop.service;

import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service to recalculate model elements positions.
 */
public class SchemaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchemaService.class);
    
    public void recalculateMechanism(final Mechanism mechanism) {
        LOGGER.trace("Start recalculating of mechanism...");
        
        if (mechanism == null) {
            LOGGER.error("Cannot recalculate mechanism which is null");
            return;
        }
        
        // ToDO replace with real code
        
        final KinematicPair kg = mechanism.getKinematicPair();
        if (kg instanceof RotationalPair) {
            final RotationalPair rp = (RotationalPair) kg;
            Double angle  = rp.getAngle() + Math.PI / 720;
            if (angle % 360 == 0) {
                angle = 0.0;
            }
            
            LOGGER.debug("New angle: '{}'", angle);
            
            rp.setAngle(angle);
        } else if (kg instanceof TranslationalPair) {
            // Nothing to do
        }
    }
    
}
