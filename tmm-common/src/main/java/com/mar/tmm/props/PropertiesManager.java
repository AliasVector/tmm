package com.mar.tmm.props;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Manager to store and restore properties.
 */
public final class PropertiesManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesManager.class);
    private static final String CONSTANT_USER_HOME = "user.home";
    private static final String FILE_NAME = "TmmApplication.properties";
    private static final String APPLICATION_PROPERTIES_COMMENT = "Application properties";

    private static PropertiesManager instance = new PropertiesManager();

    private Properties properties = new Properties();

    private PropertiesManager() {
        readPropertiesFile();
    }

    private String getHomeFolder() {
        return System.getProperty(CONSTANT_USER_HOME);
    }

    private synchronized void readPropertiesFile() {
        final File file = new File(getHomeFolder() + File.separator + FILE_NAME);
        if (file.exists() && file.canRead()) {
            try {
                properties.load(new FileInputStream(file));
            } catch (final Exception e) {
                LOGGER.error("Cannot read file: {}", file.getPath(), e);
            }
        } else {
            LOGGER.warn("Cannot find properties read: {}", file.getPath());
        }
    }

    private synchronized void writePropertiesFile() {
        final File file = new File(getHomeFolder() + File.separator + FILE_NAME);
        try {
            properties.store(new FileOutputStream(file), APPLICATION_PROPERTIES_COMMENT);
        } catch (final Exception e) {
            LOGGER.error("Cannot read file: {}", file.getPath(), e);
        }
    }

    public synchronized void storeProperty(final String key, final String value) {
        properties.setProperty(key, value);
        writePropertiesFile();
    }

    public synchronized String readProperty(final String key) {
        return properties.getProperty(key);
    }

    public void storeInt(final String key, final Integer value) {
        storeProperty(key, value == null ? null : value.toString());
    }

    public Integer readInt(final String key) {
        try {
            return NumberUtils.createInteger(readProperty(key));
        } catch (final Exception e) {
            LOGGER.error("Cannot read int by the given key: {}", key, e);
            return null;
        }
    }

    public Integer readInt(final String key, final Integer defaultValue) {
        try {
            final Integer value = NumberUtils.createInteger(readProperty(key));
            if (value == null) {
                return defaultValue;
            }
            return value;
        } catch (final Exception e) {
            LOGGER.error("Cannot read int by the given key: {}", key, e);
            return defaultValue;
        }
    }

    public static PropertiesManager getInstance() {
        return instance;
    }
}
