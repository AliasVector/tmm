package com.mar.tmm.io;

import com.mar.tmm.exception.TmmException;
import com.mar.tmm.model.Mechanism;

/**
 * Writes the model into output.
 */
public interface MechanismWriter {

    /**
     * Writes the given mechanism.
     *
     * @param mechanism mechanism to be written
     */
    <T extends Mechanism> void writeMechanism(T mechanism) throws TmmException;
}
