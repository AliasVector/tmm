package com.mar.tmm.desktop.ui;

import com.mar.tmm.desktop.props.CustomizableForm;
import com.mar.tmm.desktop.props.UIPropertiesManager;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main frame of tmm application.
 */
public class MainFrame extends javax.swing.JFrame implements CustomizableForm {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainFrame.class);

    public static final String FRAME_PREFIX = "MainFrame";
    private static final String VERTICAL_SPLIT_PANE_PREFIX = FRAME_PREFIX + ".verticalSplitPane";
    private static final String HORIZONTAL_SPLIT_PANE_PREFIX = FRAME_PREFIX + ".horizontalSplitPane";

    private MainFrameController controller;

    private int dividerVertical;
    private int dividerHorizontal;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        LOGGER.info("After init components");

        initController();
    }

    private void initController() {
        controller = new MainFrameController(this);
        controller.newMechanism();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMain = new javax.swing.JPanel();
        jSPVertical = new JMSplitPane();
        jSPHorizontal = new JMSplitPane();
        pCMechanism = new org.piccolo2d.PCanvas();
        pCDiagrams = new org.piccolo2d.PCanvas();
        jScrPData = new javax.swing.JScrollPane();
        jTData = new javax.swing.JTable();
        jMainMenuBar = new javax.swing.JMenuBar();
        jMFile = new javax.swing.JMenu();
        jMINew = new javax.swing.JMenuItem();
        jMIOpen = new javax.swing.JMenuItem();
        jMISave = new javax.swing.JMenuItem();
        jMISaveAs = new javax.swing.JMenuItem();
        jMAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("messages"); // NOI18N
        setTitle(bundle.getString("MainFrame.title")); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPMain.setLayout(new java.awt.BorderLayout());

        jSPVertical.setDividerLocation(460);
        jSPVertical.setDividerSize(5);
        jSPVertical.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSPVertical.setPreferredSize(new java.awt.Dimension(0, 0));
        jSPVertical.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSPVerticalPropertyChange(evt);
            }
        });

        jSPHorizontal.setDividerLocation(450);
        jSPHorizontal.setDividerSize(5);
        jSPHorizontal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSPHorizontalPropertyChange(evt);
            }
        });
        jSPHorizontal.setLeftComponent(pCMechanism);
        jSPHorizontal.setRightComponent(pCDiagrams);

        jSPVertical.setTopComponent(jSPHorizontal);

        jTData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrPData.setViewportView(jTData);

        jSPVertical.setRightComponent(jScrPData);

        jPMain.add(jSPVertical, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPMain, java.awt.BorderLayout.CENTER);

        jMFile.setText(bundle.getString("MainFrame.MainMenu.file")); // NOI18N

        jMINew.setText(bundle.getString("MainFrame.MainMenu.File.new")); // NOI18N
        jMINew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMINewActionPerformed(evt);
            }
        });
        jMFile.add(jMINew);

        jMIOpen.setText(bundle.getString("MainFrame.MainMenu.File.open")); // NOI18N
        jMIOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIOpenActionPerformed(evt);
            }
        });
        jMFile.add(jMIOpen);

        jMISave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMISave.setText(bundle.getString("MainFrame.MainMenu.File.save")); // NOI18N
        jMISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaveActionPerformed(evt);
            }
        });
        jMFile.add(jMISave);

        jMISaveAs.setText(bundle.getString("MainFrame.MainMenu.File.save.as")); // NOI18N
        jMISaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaveAsActionPerformed(evt);
            }
        });
        jMFile.add(jMISaveAs);

        jMainMenuBar.add(jMFile);

        jMAbout.setText(bundle.getString("MainFrame.MainMenu.about")); // NOI18N
        jMainMenuBar.add(jMAbout);

        setJMenuBar(jMainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIOpenActionPerformed
        controller.openMechanism();
    }//GEN-LAST:event_jMIOpenActionPerformed

    private void jMISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaveActionPerformed
        controller.saveMechanism();
    }//GEN-LAST:event_jMISaveActionPerformed

    private void jMISaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaveAsActionPerformed
        controller.saveMechanismAs();
    }//GEN-LAST:event_jMISaveAsActionPerformed

    private void jMINewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINewActionPerformed
        controller.newMechanism();
    }//GEN-LAST:event_jMINewActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jSPVertical.setDividerLocation(dividerVertical);
        jSPHorizontal.setDividerLocation(dividerHorizontal);
    }//GEN-LAST:event_formComponentResized

    private void jSPVerticalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSPVerticalPropertyChange
        if (JSplitPane.DIVIDER_LOCATION_PROPERTY.equals(evt.getPropertyName())) {
            dividerVertical = (Integer) evt.getNewValue();
        }
    }//GEN-LAST:event_jSPVerticalPropertyChange

    private void jSPHorizontalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSPHorizontalPropertyChange
        if (JSplitPane.DIVIDER_LOCATION_PROPERTY.equals(evt.getPropertyName())) {
            dividerHorizontal = (Integer) evt.getNewValue();
        }
    }//GEN-LAST:event_jSPHorizontalPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMAbout;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenuItem jMINew;
    private javax.swing.JMenuItem jMIOpen;
    private javax.swing.JMenuItem jMISave;
    private javax.swing.JMenuItem jMISaveAs;
    private javax.swing.JMenuBar jMainMenuBar;
    private javax.swing.JPanel jPMain;
    private javax.swing.JSplitPane jSPHorizontal;
    private javax.swing.JSplitPane jSPVertical;
    private javax.swing.JScrollPane jScrPData;
    private javax.swing.JTable jTData;
    private org.piccolo2d.PCanvas pCDiagrams;
    private org.piccolo2d.PCanvas pCMechanism;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadCustomProperties() {
        SwingUtilities.invokeLater(() -> {
            UIPropertiesManager.loadDividerLocation(jSPVertical, VERTICAL_SPLIT_PANE_PREFIX);
            dividerVertical = jSPVertical.getDividerLocation();
        });

        SwingUtilities.invokeLater(() -> {
            UIPropertiesManager.loadDividerLocation(jSPHorizontal, HORIZONTAL_SPLIT_PANE_PREFIX);
            dividerHorizontal = jSPHorizontal.getDividerLocation();
        });
    }

    @Override
    public void storeCustomProperties() {
        UIPropertiesManager.storeDividerLocation(jSPVertical, VERTICAL_SPLIT_PANE_PREFIX);
        UIPropertiesManager.storeDividerLocation(jSPHorizontal, HORIZONTAL_SPLIT_PANE_PREFIX);
    }
}
