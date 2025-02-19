/*
 * Copyright (C) 2003 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.config;

/**
 * Thrown when any exception preventing normal extraction of configuration data
 * occurs. Such exceptions are thrown by subclasses of <code>ConfigProperties
 * </code> during their interaction with underlying source of configuration data
 *
 * @author  debedeb, ilya, isv, WishingBone
 * @version 2.1  05/07/2003
 */
@SuppressWarnings("serial")
public class ConfigParserException extends ConfigManagerException {

    /**
     * Constructs a <code>ConfigParserException</code> with <code>null</code>
     * as its error detail message.
     */
    public ConfigParserException() {
        super();
    }

    /**
     * Constructs a <code>ConfigParserException</code> with the specified
     * detail message. The error message string <code>detail</code> can later be
     * retrieved by the <code>getMessage()</code> method.
     *
     * @param detail the detail message
     */
    public ConfigParserException(String detail) {
        super(detail);
    }

}
