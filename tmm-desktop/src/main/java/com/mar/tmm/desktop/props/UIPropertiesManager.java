package com.mar.tmm.desktop.props;

import com.mar.tmm.props.PropertiesManager;
import javax.swing.JFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Properties manager for ui components.
 */
public final class UIPropertiesManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(UIPropertiesManager.class);

    private UIPropertiesManager() {
    }

    public static void initFrame(final JFrame frame, final String framePrefix) {
        final PropertiesManager props = PropertiesManager.getInstance();
        final Integer width = props.readInt(framePrefix + ".width", frame.getWidth());
        final Integer height = props.readInt(framePrefix + ".height", frame.getHeight());
        final Boolean maximized = props.readBoolean(framePrefix + ".maximized",
                frame.getExtendedState() == JFrame.MAXIMIZED_BOTH);

        if (maximized) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            frame.setSize(width, height);
        }
    }

    public static void storeFrame(final JFrame frame, final String framePrefix) {
        final PropertiesManager props = PropertiesManager.getInstance();
        props.storeInt(framePrefix + ".width", frame.getWidth());
        props.storeInt(framePrefix + ".height", frame.getHeight());
        props.storeBoolean(framePrefix + ".maximized", frame.getExtendedState() == JFrame.MAXIMIZED_BOTH);
        
        props.storeProperties();
    }
}
