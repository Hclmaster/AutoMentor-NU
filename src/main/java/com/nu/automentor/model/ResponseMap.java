package com.nu.automentor.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data Structure for Map between exercise and resources
 */
public class ResponseMap {

    private Map<String, Map<String, List<String>>> responseMap = new HashMap<>();

    public ResponseMap() {
        loadExResourceJSON();
    }

    public List<String> getResponses(String exercise, String topic) {
        if(responseMap.get(exercise) != null) {
            return responseMap.get(exercise).get(topic);
        }
        return null;
    }

    private void loadExResourceJSON() {
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new InputStreamReader(getClass().getResourceAsStream("/patterns/exResources.json"));
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            jsonObject.keySet().forEach(key -> {
                JSONObject value = (JSONObject) jsonObject.get(key);
                Map<String, List<String>> funcHashMap = new HashMap<>();
                value.keySet().forEach(funcName -> {
                    JSONArray array = (JSONArray) value.get(funcName);
                    funcHashMap.put((String) funcName, (List<String>) array.stream().collect(Collectors.toList()));
                });
                responseMap.put((String) key, funcHashMap);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}