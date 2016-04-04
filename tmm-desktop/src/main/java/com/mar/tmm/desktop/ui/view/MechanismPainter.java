/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mar.tmm.desktop.ui.view;

import com.mar.tmm.model.Mechanism;
import org.piccolo2d.PCanvas;

/**
 * Painter for mechanism.
 */
public interface MechanismPainter {

    /**
     * Paints the given mechanism.
     *
     * @param mechanism mechanism to be painted
     * @param canvas canvas to paint mechanism on
     */
    void paint(Mechanism mechanism, PCanvas canvas);
}
