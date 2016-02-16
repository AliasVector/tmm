package com.mar.tmm.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    private static final String REFERENCE_XML_RESOURCE = "/test.xml";

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

    private void checkXMLFile(final String fileName) throws IOException {
        final File file = new File(fileName);

        assertTrue("File doesn't exist", file.exists());
        final String referenceFile = readFile(getClass().getResource(REFERENCE_XML_RESOURCE).getPath());
        final String testFile = readFile(fileName);

        assertEquals("Result is not correct", referenceFile, testFile);
    }

    private void removeXMLFile(final String fileName) throws IOException {
        final File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    private String readFile(final String filename) throws IOException {
        final List<String> lines = Files.readAllLines(Paths.get(filename));
        final StringBuilder sb = new StringBuilder(1024);
        for (final String line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }


    @Test
    public void testMarshallingMechanism() throws IOException {
        final Mechanism testMechanism = createTestRotationMechanism();

        final XMLMechanismWriter writer = XMLMechanismWriter.createInstance(TEST_XML_FILE);
        writer.writeMechanism(testMechanism, true);

        checkXMLFile(TEST_XML_FILE);
//        removeXMLFile(TEST_XML_FILE);
    }
}
