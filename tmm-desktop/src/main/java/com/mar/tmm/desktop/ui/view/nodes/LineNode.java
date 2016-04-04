package com.mar.tmm.desktop.ui.view.nodes;

import java.awt.Color;
import java.util.List;
import org.piccolo2d.PNode;

/**
 * Node for lever.
 */
public class LineNode extends AbstractUnitNode {
    private static final Color LINE_COLOR = Color.black;

    private final double length;

    public LineNode(final double x, final double y, final double length, final String name,
            final List<ElementNode> elements) {
        super(x, y, length, 1, name, elements);
        this.length = length;
        init();
    }

    private void init() {
        new NodesBuilder()
                .addLine(getBounds().x, getBounds().y, getBounds().x + length, getBounds().y)
                .addText(getBounds().x, getBounds().y, length, DEFAULT_FONT_SIZE, DEFAULT_FONT, 
                        DEFAULT_TEXT_COLOR, getName())
                .addNodesToParent(this);
    }

    @Override
    protected double getMiddle() {
        return getBounds().y - length / 2;
    }
    @Override
    protected double getCenter() {
        return getBounds().x - getLineThickness() / 2;
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
        return createLine(element.getBounds().x, element.getBounds().y, element.getBounds().x, getBounds().y);
    }
}
