package com.mar.tmm.desktop.ui;

import com.mar.tmm.desktop.model.MechanismStatus;
import com.mar.tmm.desktop.service.MessageService;
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
    private MechanismStatus mechanismStatus;
    
    public MainFrameController(final MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void newMechanism() {
        if (mechanismStatus == MechanismStatus.MODYFIED) {
            if (JOptionPane.showConfirmDialog(mainFrame, MessageService.getMessage("Message.mechanism.is.not.saved"), 
                    MessageService.getMessage("Message.mechanism.saving"), JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION) {
                saveMechanism();
            }
        }
        
        currentMechanism = MechanismUtils.createMechanismWithRotationKinematicPair("Mechanism", "Pair 1", "Rack 1", 
                "Lever 1");
        mechanismStatus = MechanismStatus.MODYFIED;
        currentMechanismFilePath = "";
        
        // ToDo refresh view
    }
    
    public void openMechanism() {
        if (mechanismStatus == MechanismStatus.MODYFIED) {
            if (JOptionPane.showConfirmDialog(mainFrame, MessageService.getMessage("Message.mechanism.is.not.saved"), 
                    MessageService.getMessage("Message.mechanism.saving"), JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION) {
                saveMechanism();
            }
        }
        
        // ToDo
        JOptionPane.showMessageDialog(mainFrame, MessageService.getMessage("Message.mechanism.opening"));
        mechanismStatus = MechanismStatus.STORED;
    }
    
    public void saveMechanism() {
        if (StringUtils.isEmpty(currentMechanismFilePath)) {
            saveMechanismAs();
        } else {
            // ToDo
            JOptionPane.showMessageDialog(mainFrame, MessageService.getMessage("Message.mechanism.saving"));
            mechanismStatus = MechanismStatus.STORED;
        }
    }
    
    public void saveMechanismAs() {
        // ToDo
        JOptionPane.showMessageDialog(mainFrame, MessageService.getMessage("Message.mechanism.saving.as"));
        mechanismStatus = MechanismStatus.STORED;
    }
}
