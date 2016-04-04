package com.mar.tmm.desktop.ui.view.nodes;

import java.util.List;
import org.piccolo2d.PNode;

/**
 * Abstract Node for units.
 */
public abstract class AbstractUnitNode extends AbstractNode {
    private final List<ElementNode> elements;
    
    public AbstractUnitNode(final double x, final double y, final double width, final double height, 
            final String name, final List<ElementNode> elements) {
        super(x, y, width, height, name);
        this.elements = elements;
        
        init();
    }
    
    private void init() {
        for (final ElementNode element : elements) {
            addChild(element);
            addChild(getConnectionForElement(element));
        }
    }
    
    public List<ElementNode> getElementsNodes() {
        return elements;
    }
    
    public abstract PNode getConnectionForElement(ElementNode element);
}
