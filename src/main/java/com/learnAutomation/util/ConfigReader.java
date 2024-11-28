package com.learnAutomation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Static block to load properties when the class is loaded
    static {
        try {
            // Specify the path to your config.properties file
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves the value for a given key from the config.properties file.
     *
     * @param key the key to look for in the properties file.
     * @return the value associated with the key, or null if the key is not found.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Retrieves the value for a given key from the config.properties file with a default value.
     *
     * @param key the key to look for in the properties file.
     * @param defaultValue the default value to return if the key is not found.
     * @return the value associated with the key, or the default value if the key is not found.
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
