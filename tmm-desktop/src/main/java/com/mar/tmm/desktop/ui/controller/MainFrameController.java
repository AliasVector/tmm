package com.mar.tmm.desktop.ui.controller;

import com.mar.tmm.desktop.model.MechanismState;
import com.mar.tmm.desktop.service.MessageService;
import com.mar.tmm.desktop.ui.MainFrame;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.DefaultMechanism;
import com.mar.tmm.util.MechanismUtils;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/**
 * Controller to process MainFrame model.
 * @author roman
 */
public class MainFrameController {
    private final MainFrame mainFrame;
    private DefaultMechanism currentMechanism;
    private String currentMechanismFilePath;
    private MechanismState mechanismState;
    
    public MainFrameController(final MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void newMechanism() {
        if (mechanismState == MechanismState.MODYFIED) {
            if (JOptionPane.showConfirmDialog(mainFrame, MessageService.getMessage("Message.mechanism.is.not.saved"), 
                    MessageService.getMessage("Message.mechanism.saving"), JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION) {
                saveMechanism();
            }
        }
        
        currentMechanism = MechanismUtils.createMechanismWithRotationKinematicPair("Mechanism", "Pair 1", "Rack 1", 
                "Lever 1");
        mechanismState = MechanismState.MODYFIED;
        currentMechanismFilePath = "";
        
        mainFrame.paintMechanism();
    }
    
    public void openMechanism() {
        if (mechanismState == MechanismState.MODYFIED) {
            if (JOptionPane.showConfirmDialog(mainFrame, MessageService.getMessage("Message.mechanism.is.not.saved"), 
                    MessageService.getMessage("Message.mechanism.saving"), JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION) {
                saveMechanism();
            }
        }
        
        // ToDo
        JOptionPane.showMessageDialog(mainFrame, MessageService.getMessage("Message.mechanism.opening"));
        mechanismState = MechanismState.STORED;

        mainFrame.paintMechanism();
    }
    
    public void saveMechanism() {
        if (StringUtils.isEmpty(currentMechanismFilePath)) {
            saveMechanismAs();
        } else {
            // ToDo
            JOptionPane.showMessageDialog(mainFrame, MessageService.getMessage("Message.mechanism.saving"));
            mechanismState = MechanismState.STORED;
        }
    }
    
    public void saveMechanismAs() {
        // ToDo
        JOptionPane.showMessageDialog(mainFrame, MessageService.getMessage("Message.mechanism.saving.as"));
        mechanismState = MechanismState.STORED;
    }
    
    public Mechanism getMechanism() {
        return currentMechanism;
    }
}
