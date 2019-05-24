package com.nu.automentor.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResponseMap{

    private Map<String, Map<String, List<String>>> responseMap = new HashMap<>();

    public ResponseMap() {
        loadJSON();
    }

    public List<String> getResponses(String exercise, String topic){
        return responseMap.get(exercise).get(topic);
    }

    private void loadJSON(){}

}

