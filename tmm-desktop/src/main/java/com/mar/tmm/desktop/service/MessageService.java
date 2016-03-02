package com.mar.tmm.desktop.service;

import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides i18n messages for the default locale.
 */
public class MessageService {
    public static final String MESSAGES_BINDLE_NAME = "messages";
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    
    public static String getMessage(final String key) {
        final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BINDLE_NAME);
        final String result = bundle.getString(key);
        if (StringUtils.isEmpty(result)) {
            LOGGER.error("Cannot find i18n message for the key: {}", key);
            return key;
        }
        return result;
    }
}
