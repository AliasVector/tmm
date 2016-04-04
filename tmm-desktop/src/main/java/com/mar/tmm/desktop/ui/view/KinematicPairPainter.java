/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mar.tmm.desktop.ui.view;

import com.mar.tmm.desktop.ui.view.nodes.AbstractNode;
import com.mar.tmm.model.KinematicPair;

/**
 * Painter interface for {@link KinematicPair}.
 */
public interface KinematicPairPainter {

    /**
     * Paints the given unit into corresponding node.
     *
     * @param pair kinematic pair to be paint
     * @param angle angle of the previous
     * @param <T> type of pair
     * @return instance of subclass of {@link AbstractNode}
     */
    <T extends KinematicPair> AbstractNode paint(T pair, double angle);
}
