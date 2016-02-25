package com.mar.tmm.io.impl;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.mar.tmm.io.MechanismWriter;
import com.mar.tmm.io.exception.TmmIOException;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.Unit;
import com.mar.tmm.model.impl.UnitElement;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.group.SecondTypeGroup;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Writes mechanism into XML file.
 */
public class XMLMechanismWriter implements MechanismWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLMechanismWriter.class);

    private String destination;

    private XMLMechanismWriter(final String source) {
        this.destination = source;
    }

    /**
     * Writes mechanism into xml file which is specified in constructor.
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Mechanism> void writeMechanism(final T mechanism, final boolean prettyView) {
        if (mechanism == null) {
            throw new IllegalArgumentException("Mechanism cannot be null for marshalling");
        }

        checkSource(destination);
        try {
            final File targetFile = new File(destination);

            final JAXBContext context = JAXBContext.newInstance(mechanism.getClass(), UnitElement.class,
                RotationalPair.class, TranslationalPair.class, FirstTypeGroup.class, SecondTypeGroup.class,
                Unit.class);
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyView);
            marshaller.marshal(mechanism, targetFile);
            LOGGER.debug("Mechanism: {} is successfully marshalled into file: {}", mechanism, destination);
        } catch (final Exception e) {
            LOGGER.error("Error occured during marshalling mechanism: {} into file: {}", destination,
                destination, e);
            throw new TmmIOException("Cannot marshall mechanism", e);
        }
    }

    /**
     * Creates xml writer after some checks of xml destination.
     *
     * @param xmlDestination destination file to be used for marshalling
     *
     * @return {@link XMLMechanismWriter} instance
     */
    public static XMLMechanismWriter createInstance(final String xmlDestination) {
        checkSource(xmlDestination);
        return new XMLMechanismWriter(xmlDestination);
    }

    private static void checkSource(final String xmlDestination) {
        if (StringUtils.isEmpty(xmlDestination)) {
            throw new IllegalArgumentException("Xml destination file string cannot be empty");
        }

        final File file = new File(xmlDestination);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (final Exception e) {
                LOGGER.error("Cannot create destination file: {}", xmlDestination, e);
                throw new TmmIOException("Cannot create destination file", e);
            }
        }

        if (!file.canWrite()) {
            LOGGER.error("Access denied to the xml destination: {}", xmlDestination);
            throw new IllegalStateException("Access denied to the xml destination");
        }
    }
}
