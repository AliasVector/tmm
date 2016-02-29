package com.mar.tmm.desktop;

import com.mar.tmm.desktop.ui.MainFrame;
import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desktop application for tmm project.
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        initLookAndFeel();
        
        invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    private static void initLookAndFeel() {
        try {
            for (final LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (final Exception e) {
            LOGGER.error("Cannot set nimbus look and feel. "
                    + "Set cross platform llok and feel", e);

            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (final Exception ex) {
                LOGGER.error("Cannot set crossplatform look and feel.", ex);
            }
        }
    }
}
