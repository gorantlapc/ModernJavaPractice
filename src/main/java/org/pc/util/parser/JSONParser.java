package org.pc.util.parser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JSONParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> readJson(String filePath, Class<T> tClass) throws IOException {
        // Load the JSON file from
        InputStream resource = getClass().getClassLoader().getResourceAsStream(filePath);
        if (resource == null) {
            throw new IOException("File not found: " + filePath);
        }
        // Map the content of the JSON file to a List of tClass objects
        return objectMapper.readValue(resource, objectMapper.getTypeFactory().constructCollectionType(List.class, tClass));
    }

    public <T> Map<String, List<T>> readJsonToMap(String filePath, Class<T> elementClass) throws IOException {
        InputStream resource = getClass().getClassLoader().getResourceAsStream(filePath);

        if (resource == null) {
            throw new IOException("File not found: " + filePath);
        }
        // Map the content of the JSON file to a List of tClass objects
        JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass);
        JavaType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, objectMapper.getTypeFactory().constructType(String.class), listType);
        return objectMapper.readValue(resource, mapType);

    }

}
