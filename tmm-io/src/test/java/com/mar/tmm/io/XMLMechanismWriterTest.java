package com.mar.tmm.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.mar.tmm.io.impl.XMLMechanismReader;
import com.mar.tmm.io.impl.XMLMechanismWriter;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.DefaultMechanism;
import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.util.GroupUtils;
import com.mar.tmm.util.KinematicUtils;
import com.mar.tmm.util.MechanismUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.After;
import org.junit.Test;

public class XMLMechanismWriterTest {

    private static final String TEST_XML_FILE = "./test.xml";
    private static final String REFERENCE_XML_RESOURCE = "/test.xml";

    @After
    public void cleanUp() throws IOException {
      //  removeXMLFile(TEST_XML_FILE);
    }

    private Mechanism createTestRotationMechanism() {
        final Mechanism testMechanism = MechanismUtils.createMechanismWithRotationKinematicPair("Test mechanism",
            "First rotation pair", "First rack", "Test lever 1");

        final FirstTypeGroup group = GroupUtils.createFirstTypeGroup("Test group 1", "Ext pair 1", "Ext pair 2",
            "Internal pair", "Lever 1", "Lever 2");

        testMechanism.connectGroupToMechanism(group, group.getExternalPair1());

        final Unit rackUnit = new Unit();
        rackUnit.setName("Last Rack");
        rackUnit.setFixed(true);
        final UnitElement rackElement = KinematicUtils.createElementForUnit(rackUnit, 0, 0);
        group.getExternalPair2().setUnitElement2(rackElement);
        rackElement.setKinematicPair(group.getExternalPair2());

        return testMechanism;
    }

    private void checkXMLFile(final String fileName) throws IOException {
        final File file = new File(fileName);

        assertTrue("File doesn't exist", file.exists());
//        final String referenceFile = readFile(getClass().getResource(REFERENCE_XML_RESOURCE).getPath());
//        final String testFile = readFile(fileName);
//
//        assertEquals("Result is not correct", referenceFile, testFile);
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

    private void compareMechanisms(final Mechanism referenceMechanism, final Mechanism testMechanism) {
        assertNotNull("Reference mechanism cannot be null", referenceMechanism);
        assertNotNull("Test mechanism cannot be null", testMechanism);

        assertEquals("Mechanisms are not equals", referenceMechanism, testMechanism);

        final String referenceToString = referenceMechanism.toString();
        final String testToString = testMechanism.toString();

        assertEquals("Reference and test mechanisms are not the equals", referenceToString, testToString);

//
//        // Mechanisms' units
//        compareUnits(referenceMechanism.getRackUnit(), testMechanism.getRackUnit());
//        compareUnits(referenceMechanism.getLeverUnit(), testMechanism.getLeverUnit());
//        // Mechanisms' kinematic pairs
//        assertEquals("Mechanisms' kinematic pairs are not equals", referenceMechanism.getKinematicPair(),
//            testMechanism.getKinematicPair());
//
//        // Mechanisms' groups
//        assertEquals("Reference mechanism groups and test mechanism groups have different sizes",
//            CollectionUtils.size(referenceMechanism.getGroups()), CollectionUtils.size(testMechanism.getGroups()));
//        for (final Group referenceGroup : referenceMechanism.getGroups()) {
//            assertTrue("Test mechanism doesn't contain all reference groups",
//                testMechanism.getGroups().contains(referenceGroup));
//
//            final int index = testMechanism.getGroups().indexOf(referenceGroup);
//            final Group testGroup = testMechanism.getGroups().get(index);
//
//            compareGroups(referenceGroup, testGroup);
//        }
    }

    private void compareUnits(final Unit referenceUnit, final Unit testUnit) {
        assertNotNull("Reference unit cannot be null", referenceUnit);
        assertNotNull("Test unit cannot be null", testUnit);

        assertEquals("Units are not equals", referenceUnit, testUnit);

        assertEquals("Reference unit elements and test unit elements sizes are not the same",
            CollectionUtils.size(referenceUnit.getElements()), CollectionUtils.size(testUnit.getElements()));

        for (final UnitElement referenceElement : referenceUnit.getElements()) {
            assertTrue("Reference unit contains element which is not in test unit",
                testUnit.getElements().contains(referenceElement));

            final int index = testUnit.getElements().indexOf(referenceElement);
            final UnitElement testElement = testUnit.getElements().get(index);

            compareElements(referenceElement, testElement);
        }
    }

    private void compareElements(final UnitElement referenceElement, final UnitElement testElement) {
        assertNotNull("Reference unit element cannot be null", referenceElement);
        assertNotNull("Test unit element cannot be null", testElement);

        assertEquals("Reference unit element kinematic pair is not the same as test unit element kinematic pair",
            referenceElement.getKinematicPair(), testElement.getKinematicPair());

        assertEquals("Reference unit element disposition is not the same as test unit element disposition",
            referenceElement.getDisposition(), testElement.getDisposition());

        assertEquals("Reference unit element unit is not the same as test unit element unit",
            referenceElement.getUnit(), testElement.getUnit());
    }

    private void compareGroups(final Group referenceGroup, final Group testGroup) {
        assertNotNull("Reference group cannot be null", referenceGroup);
        assertNotNull("Test group cannot be null", testGroup);

        assertEquals("Test group and reference group are not the same", referenceGroup, testGroup);
        assertEquals("Test group type and reference group type are not the same", referenceGroup.getType(),
            testGroup.getType());

//        for (final KinematicPair refExtKinematicPair : referenceGroup.getExternalKinematicPairs()) {
//            assertTrue("Test group doesn't contains reference ext ")
//
//            compareDescendingKinematicPairs(final KinematicPair referencePair, final KinematicPair testPair);
//        }

    }

    @Test
    public void testMarshallingUnmarshallingMechanism() throws IOException {
        final Mechanism referenceMechanism = createTestRotationMechanism();

        final XMLMechanismWriter writer = XMLMechanismWriter.createInstance(TEST_XML_FILE);
        writer.writeMechanism(referenceMechanism, true);

        checkXMLFile(TEST_XML_FILE);

        final XMLMechanismReader reader = XMLMechanismReader.createInstance(TEST_XML_FILE);
        final Mechanism testMechanism = reader.readMechanism(DefaultMechanism.class);

        compareMechanisms(referenceMechanism, testMechanism);
    }
}
