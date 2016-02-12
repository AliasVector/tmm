package com.mar.tmm.io;

import java.io.File;

import static org.junit.Assert.assertTrue;

import com.mar.tmm.io.impl.XMLMechanismWriter;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.unit.RackUnit;
import com.mar.tmm.util.GroupUtils;
import com.mar.tmm.util.KinematicUtils;
import com.mar.tmm.util.MechanismUtils;
import org.junit.Test;

public class XMLMechanismWriterTest {

    private static final String TEST_XML_FILE = "./test.xml";

    private Mechanism createTestRotationMechanism() {
        final Mechanism testMechanism = MechanismUtils.createMechanismWithRotationKinematicPair("Test mechanism",
            "First rotation pair", "First rack", "Test lever 1");

        final FirstTypeGroup group = GroupUtils.createFirstTypeGroup("Test group 1", "Ext pair 1", "Ext pair 2",
            "Internal pair", "Lever 1", "Lever 2");

        testMechanism.connectGroupToMechanism(group, group.getExternalKinematicPairs().get(0));

        final RackUnit rackUnit = new RackUnit();
        rackUnit.setName("Last Rack");
        final Unit.Element rackElement = KinematicUtils.createElementForUnit(rackUnit, 0, 0);
        group.getExternalKinematicPairs().get(1).setElement2(rackElement);
        rackElement.setKinematicPair(group.getExternalKinematicPairs().get(1));

        return testMechanism;
    }

    private void checkXMLFile(final String fileName) {
        final File file = new File(fileName);

        assertTrue("File doesn't exist", file.exists());
    }

    @Test
    public void testMarshallingMechanism() {
        final Mechanism testMechanism = createTestRotationMechanism();

        final XMLMechanismWriter writer = XMLMechanismWriter.createInstance(TEST_XML_FILE);
        writer.writeMechanism(testMechanism);

        checkXMLFile(TEST_XML_FILE);
    }
}
