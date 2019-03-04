package com.fkfc.receitasapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    public static Object getObject(String jsonString, Class<?> classType) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, classType);
    }

    public static Object getObject(Map<String, String> payload, Class<?> classType) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(payload, classType);
    }
}
