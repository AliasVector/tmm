package com.mar.tmm.desktop.ui.view.nodes;

import com.mar.tmm.model.impl.Disposition;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

/**
 * Abstract Nodes.
 */
public abstract class AbstractNode extends PNode {
    protected static final float DEFAUILT_LINE_THICKNESS = 2.5f;
    protected static final int DEFAULT_FONT_SIZE = 20;
    protected static final Font DEFAULT_FONT = new Font("Arial", Font.BOLD, DEFAULT_FONT_SIZE);
    protected static final double DEFAULT_TEXT_OFFSET_X = 0;
    protected static final double DEFAULT_TEXT_OFFSET_Y = 5;
    protected static final Color DEFAULT_TEXT_COLOR = Color.BLACK;
    protected static final float DEFAULT_NODE_TRANSPARENCY = 1;
    
    protected static final int DEFAULT_LINE_CAP = BasicStroke.CAP_ROUND;
    protected static final int DEFAULT_LINE_JOIN = BasicStroke.JOIN_ROUND;
    
    private Stroke defaultLineStroke;
    
    public AbstractNode(final double x, final double y, final double width, final double height, final String name) {
        init(x, y, width, height, name);
    }
    
    private void init(final double x, final double y, final double width, final double height, final String name) {
        setBounds(x, y, width, height);
        setName(name);
        defaultLineStroke = new BasicStroke(getLineThickness(), getLineCap(), getLineJoin());
    }   

    protected abstract float getLineThickness();

    protected abstract Color getLineColor();
    
    protected int getLineCap() {
        return DEFAULT_LINE_CAP;
    }
    
    protected int getLineJoin() {
        return DEFAULT_LINE_JOIN;
    }
    
    protected float getNodeTransparency() {
        return DEFAULT_NODE_TRANSPARENCY;
    }
    
    protected abstract double getMiddle();

    protected abstract double getCenter();

    public void rotateAroundCenter(final double angle) {
        final Double x = getCenter();
        final Double y = getMiddle();
        
        rotateAboutPoint(angle, x, y);
    }
    
    protected Disposition calculateDisposition(final double x, final double y, final double length, 
            final double angle) {
        
        final double x2  = x + Math.cos(angle) * length;
        final double y2  = y - Math.sin(angle) * length;
        return new Disposition(x2, y2);
    }
    
    protected PNode createLine(final double x1, final double y1, final double x2, final double y2) {
        return createLine(x1, y1, x2, y2, getLineColor());
    }

    protected PNode createLine(final double x1, final double y1, final double x2, final double y2, final Color color) {
        final PPath line = PPath.createLine(x1, y1, x2, y2);
        line.setStroke(defaultLineStroke);
        line.setStrokePaint(color);
        return line;
    }

    protected PNode createLineAndRotate(final double x1, final double y1, final double length, final double angle) {
        return createLineAndRotate(x1, y1, length, angle, getLineColor());
    }

    protected PNode createLineAndRotate(final double x1, final double y1, final double length, final double angle, 
            final Color color) {
        
        final PPath line = PPath.createLine(x1, y1, x1 + length, y1);
        line.setStroke(defaultLineStroke);
        line.setStrokePaint(color);
        line.setRotation(angle);
        return line;
    }

    protected PText createText(final double x, final double y, final double width, final double height, 
            final Font font, final Color color, final String text) {
        
        final PText caption = new PText(text);
        caption.setFont(font == null ? DEFAULT_FONT : font);
        caption.setTextPaint(Color.BLACK);
        caption.setBounds(x, y, width, height);
        caption.setOffset(DEFAULT_TEXT_OFFSET_X, DEFAULT_TEXT_OFFSET_Y);
        return caption;
    }

    protected PNode createCircle(final double x1, final double y1, final double diameter) {
        return createCircle(x1, y1, diameter, getLineColor());
    }

    protected PNode createCircle(final double x1, final double y1, final double diameter, final Color color) {
        final PPath circle = PPath.createEllipse(x1, y1, diameter, diameter);
        circle.setStroke(defaultLineStroke);
        circle.setStrokePaint(color);
        return circle;
    }

    protected PNode createRect(final double x, final double y, final double width, final double height) {
        return createRect(x, y, width, height, getLineColor());
    }

    protected PNode createRect(final double x, final double y, final double width, final double height, 
            final Color color) {
        
        final PPath rect = PPath.createRectangle(x, y, width, height);
        rect.setStroke(defaultLineStroke);
        rect.setStrokePaint(color);
        
        final Color paint = new Color(1, 1, 1, getNodeTransparency());
        rect.setPaint(paint);
        return rect;
    }
    
    class NodesBuilder {
        private List<PNode> nodes = new ArrayList<>();
        
        public NodesBuilder addLine(final double x1, final double y1, final double x2, final double y2) {
            nodes.add(createLine(x1, y1, x2, y2));
            return this;
        }

        public NodesBuilder addLineAndRotate(final double x1, final double y1, final double length, 
                final double angle) {
            nodes.add(createLineAndRotate(x1, y1, length, angle));
            return this;
        }

        public NodesBuilder addNode(final PNode node) {
            nodes.add(node);
            return this;
        }

        public NodesBuilder addText(final double x, final double y, final double width, final double height, 
            final Font font, final Color color, final String text) {
            nodes.add(createText(x, y, width, height, font, color, text));
            return this;
        }

        public NodesBuilder addCircle(final double x1, final double y1, final double diameter) {
            nodes.add(createCircle(x1, y1, diameter));
            return this;
        }

        public NodesBuilder addRect(final double x, final double y, final double width, final double height) {
            nodes.add(createRect(x, y, width, height));
            return this;
        }
        
        public void addNodesToParent(final PNode parent) {
            nodes.forEach(line -> {
                parent.addChild(line);
            });
        }
        
        public List<PNode> getNodes() {
            return nodes;
        }
    }
}
