package org.pc.util.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JSONParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> readJson(String filePath, Class<T> tClass) throws IOException {
        // Load the JSON file from
        InputStream resource = getClass().getClassLoader().getResourceAsStream(filePath);
        if (resource == null) {
            throw new IOException("File not found: " + filePath);
        }
        // Map the content of the JSON file to a List of tClass objects
        return objectMapper.readValue(resource,
                objectMapper.getTypeFactory().constructCollectionType(List.class, tClass));
    }

}
