/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mar.tmm.desktop.ui.view.impl;

import com.mar.tmm.desktop.ui.view.UnitPainter;
import com.mar.tmm.desktop.ui.view.nodes.AbstractNode;
import com.mar.tmm.desktop.ui.view.nodes.AbstractUnitNode;
import com.mar.tmm.desktop.ui.view.nodes.ElementNode;
import com.mar.tmm.desktop.ui.view.nodes.LineNode;
import com.mar.tmm.desktop.ui.view.nodes.RackNode;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.Unit;
import com.mar.tmm.model.impl.UnitElement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation of {@link UnitPainter} interface.
 */
public class DefaultUnitPainter implements UnitPainter {

    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultUnitPainter.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractNode paint(final Unit unit, final double angle) {
        if (unit == null) {
            LOGGER.warn("Cannot paint unit which is null");
            return null;
        }

        return unit.isFixed() ? paintRackUnit(unit) : paintLineUnit(unit, angle);
    }

    protected AbstractNode paintRackUnit(final Unit rackUnit) {
        LOGGER.debug("Paint rack node from unit: {}...", rackUnit);
        final Disposition disposition = rackUnit.getDisposition();
        final double x = disposition.getOffsetX();
        final double y = disposition.getOffsetY();

        LOGGER.debug("Paint rack node elements...");
        final List<ElementNode> elements = paintUnitElements(rackUnit);
        LOGGER.debug("Finished painting rack node elements...");

        final AbstractUnitNode result = new RackNode(x, y, rackUnit.getName(), elements);

        LOGGER.debug("Finished painting rack node");
        return result;
    }

    protected AbstractNode paintLineUnit(final Unit lineUnit, final double angle) {
        LOGGER.debug("Paint rack node from unit: {} with angle: {}...", lineUnit, angle);
        final Disposition disposition = lineUnit.getDisposition();
        final double x = disposition.getOffsetX();
        final double y = disposition.getOffsetY();

        LOGGER.debug("Paint line node elements...");
        final List<ElementNode> elements = paintUnitElements(lineUnit);
        LOGGER.debug("Finished painting line node elements...");

        final AbstractUnitNode result = new LineNode(x, y, lineUnit.getLength(), lineUnit.getName(), elements);
        result.rotate(angle);
        LOGGER.debug("Finished painting line node");
        return result;
    }

    protected ElementNode paintUnitElement(final Unit unit, final UnitElement element) {
        final double x = element.getDisposition().getOffsetX() + unit.getDisposition().getOffsetX();
        final double y = element.getDisposition().getOffsetY() + unit.getDisposition().getOffsetY();
        
        return new ElementNode(x, y);
    }
    
    protected List<ElementNode> paintUnitElements(final Unit unit) {
        final List<ElementNode> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(unit.getElements())) {
            for (final UnitElement unitElement : unit.getElements()) {
                result.add(paintUnitElement(unit, unitElement));
            }
        }
        return result;
    }
}
