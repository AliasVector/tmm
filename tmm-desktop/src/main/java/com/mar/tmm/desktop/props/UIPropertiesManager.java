package com.mar.tmm.desktop.props;

import com.mar.tmm.props.PropertiesManager;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Properties manager for ui components.
 */
public final class UIPropertiesManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(UIPropertiesManager.class);

    private static final String POSTFIX_MAXIMIZED = ".maximized";
    private static final String POSTFIX_TOP = ".top";
    private static final String POSTFIX_LEFT = ".left";
    private static final String POSTFIX_HEIGHT = ".height";
    private static final String POSTFIX_WIDTH = ".width";
    private static final String POSTFIX_DIVIDER_LOCATION = ".dividerLocation";

    private UIPropertiesManager() {
    }

    public static <T extends JFrame> void initFrame(final T form, final String framePrefix) {
        LOGGER.debug("Start initializing frame configs...");
        final PropertiesManager props = PropertiesManager.getInstance();
        final Integer width = props.readInt(framePrefix + POSTFIX_WIDTH, form.getWidth());
        final Integer height = props.readInt(framePrefix + POSTFIX_HEIGHT, form.getHeight());
        final Integer left = props.readInt(framePrefix + POSTFIX_LEFT, form.getX());
        final Integer top = props.readInt(framePrefix + POSTFIX_TOP, form.getY());
        final Boolean maximized = props.readBoolean(framePrefix + POSTFIX_MAXIMIZED,
                form.getExtendedState() == JFrame.MAXIMIZED_BOTH);

        if (maximized) {
            form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            form.setSize(width, height);
            form.setLocation(left, top);
        }

        if (form instanceof CustomizableForm) {
            LOGGER.debug("Frame is customizable form. Init custom properties");
            ((CustomizableForm) form).loadCustomProperties();
        }

        LOGGER.debug("Finished initializing frame configs");
    }

    public static <T extends JFrame> void storeFrame(final T form, final String framePrefix) {
        LOGGER.debug("Started storing frame configs...");
        final PropertiesManager props = PropertiesManager.getInstance();
        props.storeInt(framePrefix + POSTFIX_WIDTH, form.getWidth());
        props.storeInt(framePrefix + POSTFIX_HEIGHT, form.getHeight());
        props.storeInt(framePrefix + POSTFIX_LEFT, form.getX());
        props.storeInt(framePrefix + POSTFIX_TOP, form.getY());
        props.storeBoolean(framePrefix + POSTFIX_MAXIMIZED, form.getExtendedState() == JFrame.MAXIMIZED_BOTH);

        if (form instanceof CustomizableForm) {
            LOGGER.debug("Frame is customizable form. Store custom properties");
            ((CustomizableForm) form).storeCustomProperties();
        }

        props.storeProperties();
        LOGGER.debug("Finished storing frame configs");
    }

    public static void loadDividerLocation(final JSplitPane splitPane, final String prefix) {
        LOGGER.debug("Started loading divider location for split pane: {}...", prefix);
        final PropertiesManager props = PropertiesManager.getInstance();
        final int dividerLocation = props.readInt(prefix + POSTFIX_DIVIDER_LOCATION, splitPane.getDividerLocation());
        splitPane.setDividerLocation(dividerLocation);
        LOGGER.debug("Finished loading divider location for split pane: {} - {}", prefix, dividerLocation);
    }

    public static void storeDividerLocation(final JSplitPane splitPane, final String prefix) {
        LOGGER.debug("Started storing divider location for split pane: {}...", prefix);
        final PropertiesManager props = PropertiesManager.getInstance();
        props.storeInt(prefix + POSTFIX_DIVIDER_LOCATION, splitPane.getDividerLocation());
        LOGGER.debug("Finished storing divider location for split pane: {} - {}", prefix, 
                splitPane.getDividerLocation());
    }
}
