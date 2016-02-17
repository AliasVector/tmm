package com.mar.tmm.io.impl;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.mar.tmm.io.MechanismReader;
import com.mar.tmm.io.exception.TmmIOException;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.group.FirstTypeGroup;
import com.mar.tmm.model.impl.group.SecondTypeGroup;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import com.mar.tmm.model.impl.unit.DefaultElement;
import com.mar.tmm.model.impl.unit.LeverUnit;
import com.mar.tmm.model.impl.unit.RackUnit;
import com.mar.tmm.model.impl.unit.SlideUnit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads mechanism from XML file.
 */
public class XMLMechanismReader implements MechanismReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLMechanismReader.class);

    private String source;

    private XMLMechanismReader(final String source) {
        this.source = source;
    }

    /**
     * Reads mechanism from xml file which is specified in constructor.
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Mechanism> Mechanism readMechanism(final Class<T> targetType) {
        if (targetType == null) {
            throw new IllegalArgumentException("Target type cannot be null for unmarshalling");
        }

        checkSource(source);
        try {
            final File sourceFile = new File(source);

            final JAXBContext context = JAXBContext.newInstance(targetType, DefaultElement.class,
                RotationalPair.class, TranslationalPair.class, FirstTypeGroup.class, SecondTypeGroup.class,
                RackUnit.class, LeverUnit.class, SlideUnit.class);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            final T result = (T) unmarshaller.unmarshal(sourceFile);

            LOGGER.debug("Source file: {} is successfully unmarshalled into: {}", source, result);
            return result;
        } catch (final Exception e) {
            LOGGER.error("Error occured during unmarshalling source: {} into mechanism class: {}", source,
                targetType, e);
            throw new TmmIOException("Cannot unmarshall source", e);
        }
    }

    /**
     * Creates xml reader to unmarshall xml sources into mechanisms.
     *
     * @param xmlSource xml source file to be unmarshalled
     *
     * @return {@link XMLMechanismReader} instance
     */
    public static XMLMechanismReader createInstance(final String xmlSource) {
        checkSource(xmlSource);
        return new XMLMechanismReader(xmlSource);
    }

    private static void checkSource(final String xmlSource) {
        if (StringUtils.isEmpty(xmlSource)) {
            throw new IllegalArgumentException("Xml source string cannot be empty");
        }

        final File file = new File(xmlSource);
        if (!file.exists() || !file.isFile()) {
            LOGGER.error("Xml source: {} doesn't exist or is not a file", xmlSource);
            throw new IllegalArgumentException("Xml source is not exist");
        }

        if (!file.canRead()) {
            LOGGER.error("Access denied to the xml source: {}", xmlSource);
            throw new IllegalStateException("Access denied to the xml source");
        }
    }
}
