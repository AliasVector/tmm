package com.mar.tmm.desktop.ui.view.nodes;

import java.awt.Color;

/**
 * Node for lever.
 */
public class ElementNode extends AbstractNode {
    private static final Color LINE_COLOR = Color.MAGENTA;
    private static final double DIAMETER = 5;
    
    
    public ElementNode(final double x, final double y) {
        super(x, y, DIAMETER, DIAMETER, "");
        init();
    }

    @Override
    protected double getMiddle() {
        return getBounds().y - DIAMETER / 2;
    }
    @Override
    protected double getCenter() {
        return getBounds().x - DIAMETER / 2;
    }
    
    private void init() {
        new NodesBuilder()
                .addCircle(getCenter(), getMiddle(), DIAMETER)
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
}
