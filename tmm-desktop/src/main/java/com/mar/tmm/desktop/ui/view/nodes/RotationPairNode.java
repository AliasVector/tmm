package com.mar.tmm.desktop.ui.view.nodes;

import java.awt.Color;

/**
 * Node for rotational pair.
 */
public class RotationPairNode extends AbstractNode {

    private static final double DIAMETER = 10;
    private static final double CENTER = DIAMETER / 2;
    
    private static final Color LINE_COLOR = Color.BLUE;

    public RotationPairNode(final double x, final double y, final String name) {
        super(x, y, DIAMETER, DIAMETER, name);
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
