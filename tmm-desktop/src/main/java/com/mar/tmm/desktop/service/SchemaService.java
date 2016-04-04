package com.mar.tmm.desktop.service;

import com.mar.tmm.model.Mechanism;
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
        
        
    }
    
}
