package com.mar.tmm.util;

import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.UnitElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for tmm elements.
 */
public final class KinematicUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(KinematicUtils.class);

    private KinematicUtils() {
    }

    /**
     * Creates {@link com.mar.tmm.model.Unit.Element} instance and initializes it with {@link Disposition} object.
     * Also add this newly created element to the given unit.
     *
     * @param elementUnit unit to be used as element owner
     * @param offsetX     offset for x for disposition object
     * @param offsetY     offset for y for disposition object
     *
     * @return anonymous class {@link com.mar.tmm.model.Unit.Element} instance
     */
    public static UnitElement createElementForUnit(final Unit elementUnit, final double offsetX,
        final double offsetY) {

        if (elementUnit == null) {
            throw new IllegalArgumentException("Unit cannot be null for element creation");
        }

        final UnitElement result = new UnitElement();
        result.setUnit(elementUnit);
        result.setDisposition(new Disposition(offsetX, offsetY));

        elementUnit.getElements().add(result);
        return result;
    }

}
