/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mar.tmm.desktop.ui.view.nodes;

import java.awt.Color;
import java.util.List;
import org.piccolo2d.PNode;

/**
 * Node for rack unit.
 */
public class RackNode extends AbstractUnitNode {
    private static final double WIDTH = 80;
    private static final double HEIGHT = 45;

    private static final double X_CENTER = WIDTH / 2;
    private static final double Y_CENTER = HEIGHT - 10;
    private static final double X_OFFSET = 20;
    private static final double STEP = 10;

    private static final Color LINE_COLOR = Color.BLUE;

    public RackNode(final double x, final double y, final String name,  final List<ElementNode> elements) {
        super(x, y, WIDTH, HEIGHT, name, elements);
        init();
    }

    private double getLeft() {
        return getBounds().x - X_CENTER;
    }

    private double getLeftWithOffset() {
        return getLeft() + X_OFFSET;
    }

    private double getRight() {
        return getBounds().x + X_CENTER;
    }

    private double getRightWithOffset() {
        return getRight() - X_OFFSET;
    }

    private double getTop() {
        return getBounds().y;
    }

    private double getBottom() {
        return getBounds().y + HEIGHT;
    }

    @Override
    protected double getMiddle() {
        return getBounds().y + Y_CENTER;
    }

    @Override
    protected double getCenter() {
        return getBounds().x;
    }

    private void init() {
        final double left = getLeft();
        final double right = getRight();
        final double center = getCenter();
        final double top = getTop();
        final double middle = getMiddle();
        final double bottom = getBottom();
        final NodesBuilder builder = new NodesBuilder()
                .addLine(center, top, getLeftWithOffset(), middle)
                .addLine(center, top, getRightWithOffset(), middle)
                .addLine(left, middle, right, middle);
        for (int index = 0; index < WIDTH / STEP; index++) {
            builder.addNode(createDiagonal(left, bottom, STEP, index));
        }
        builder.addText(left, bottom, WIDTH, DEFAULT_FONT_SIZE, DEFAULT_FONT, DEFAULT_TEXT_COLOR, getName())
            .addNodesToParent(this);
    }

    private PNode createDiagonal(final double x, final double y, final double step, final int number) {
        final double x1 = x + step * number;
        final double x2 = x1 + step;
        final double y1 = y;
        final double y2 = y1 - step;

        return createLine(x1, y1, x2, y2, getLineColor());
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
    public PNode getConnectionForElement(final ElementNode element) {
        return createLine(element.getBounds().x, element.getBounds().y, getCenter(), getTop());
    }
}
