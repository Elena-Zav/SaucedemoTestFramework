package com.saucelabs.saucedemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {

    private static ReadYamlFiles readYamlFiles;
    private Map<String, Object> propertyMap;

    private ReadYamlFiles(String filepath) throws FileNotFoundException {
        FileInputStream fileInputStream = FileUtility.getFileInputStream(filepath);
        Yaml yaml = new Yaml();
        this.propertyMap = yaml.load(fileInputStream);
    }

    public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
        if (readYamlFiles == null)
            return new ReadYamlFiles(filePath);
        return readYamlFiles;
    }

    public Map<String, Object> getYamlProperty(String key) {
        Object prop = this.propertyMap.get(key);
        if (prop instanceof Map) {
            return (Map<String, Object>) prop;
        }
        return new HashMap<>();
    }
}