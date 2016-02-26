package com.mar.tmm.io.impl;

import java.io.File;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.google.common.collect.Sets;
import com.mar.tmm.io.MechanismReader;
import com.mar.tmm.io.exception.TmmIOException;
import com.mar.tmm.model.Mechanism;
import com.mar.tmm.model.impl.kinematicpair.AbstractKinematicPair;
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

            // Kinematic pairs for postprocessing
            final Set<AbstractKinematicPair> pairs = Sets.newHashSet();

            final JAXBContext context = JAXBContext.newInstance(targetType);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setListener(new Unmarshaller.Listener() {
                @Override
                public void beforeUnmarshal(final Object target, final Object parent) {
                    super.beforeUnmarshal(target, parent);
                }

                @Override
                public void afterUnmarshal(final Object target, final Object parent) {
                    super.afterUnmarshal(target, parent);

                    if (target instanceof AbstractKinematicPair) {
                        pairs.add((AbstractKinematicPair) target);
                    }
                }
            });

            final T result = (T) unmarshaller.unmarshal(sourceFile);

            // Postprocess pairs to set up theirselves into xml transient elements
            postProcessPairs(pairs);

            LOGGER.debug("Source file: {} is successfully unmarshalled into: {}", source, result);
            return result;
        } catch (final Exception e) {
            LOGGER.error("Error occured during unmarshalling source: {} into mechanism class: {}", source,
                targetType, e);
            throw new TmmIOException("Cannot unmarshall source", e);
        }
    }

    private void postProcessPairs(final Set<AbstractKinematicPair> pairs) {
        for (final AbstractKinematicPair pair : pairs) {
            if (pair.getUnitElement1() != null) {
                pair.getUnitElement1().setKinematicPair(pair);
            }
            if (pair.getUnitElement2() != null) {
                pair.getUnitElement2().setKinematicPair(pair);
            }
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
