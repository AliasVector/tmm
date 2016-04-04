/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mar.tmm.desktop.ui.view.nodes;

import java.awt.Color;

/**
 * Node for translation pair.
 */
public class TranslationPairNode extends AbstractNode {

    private static final double WIDTH = 60;
    private static final double HEIGHT = 20;
    private static final double CENTER = WIDTH / 2;
    private static final double MIDDLE = HEIGHT / 2;
    
    private static final Color LINE_COLOR = Color.BLUE;

    public TranslationPairNode(final double x, final double y, final String name) {
        super(x, y, WIDTH, HEIGHT, name);
        init();
    }

    private double getTop() {
        return getBounds().y - MIDDLE;
    }

    private double getLeft() {
        return getBounds().x - CENTER;
    }
    
    @Override
    protected double getMiddle() {
        return getBounds().y;
    }

    @Override
    protected double getCenter() {
        return getBounds().x;
    }

    private void init() {
        new NodesBuilder()
                .addRect(getLeft(), getTop(), WIDTH, HEIGHT)
                .addNodesToParent(this);
    }

    @Override
    protected float getLineThickness() {
        return DEFAUILT_LINE_THICKNESS;
    }

    @Override
    protected Color getLineColor() {
        return LINE_COLOR;
    }
    
    @Override
    protected float getNodeTransparency() {
        return 0.5f;
    }
}
