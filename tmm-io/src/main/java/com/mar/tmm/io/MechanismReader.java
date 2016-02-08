package com.mar.tmm.io;

import com.mar.tmm.exception.TmmException;
import com.mar.tmm.model.Mechanism;

/**
 * Reads the source and parse mechanism model.
 */
public interface MechanismReader {

    /**
     * Reads the data and parse {@link Mechanism} model.
     *
     * @return {@link Mechanism} instance
     */
    <T extends Mechanism> Mechanism readMechanism(Class<T> targetClass) throws TmmException;
}
