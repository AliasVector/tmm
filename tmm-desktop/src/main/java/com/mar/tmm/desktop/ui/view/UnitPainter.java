/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mar.tmm.desktop.ui.view;

import com.mar.tmm.desktop.ui.view.nodes.AbstractNode;
import com.mar.tmm.model.impl.Unit;

/**
 * Painter interface for {@link Unit}.
 */
public interface UnitPainter {

    /**
     * Paints the given unit into corresponding node.
     *
     * @param unit unit to be paint
     * @param angle angle of the unit
     * @return instance of subclass of {@link AbstractNode}
     */
    AbstractNode paint(Unit unit, double angle);
}
