package com.nu.automentor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nu.automentor.model.DataEntity;
import com.nu.automentor.model.InputObj;
import com.nu.automentor.model.RequestWrapper;
import com.nu.automentor.model.ResponseWrapper;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientController {

    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper getResponses
            (@RequestBody RequestWrapper requestWrapper) {
        String objAsStr = mapInputMsgToJSONStr(requestWrapper);
        List<JSONObject> jsonObj = loadJSONFiles();

        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStudent(requestWrapper.getStudent());
        responseWrapper.setTextBlocks(requestWrapper.getTextBlocks());
        responseWrapper.setMessage(requestWrapper.getMessage());
        responseWrapper.setResponse(getMatchResponses(jsonObj, objAsStr));

        return responseWrapper;
    }

    /**
     * Load Nashorn Engine to read JS file
     *
     * @return
     */
    public ScriptEngine loadNashornEngine() {
        try {
            ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");
            InputStream is = getClass().getResourceAsStream("/static/utils/matcher.js");
            Reader reader = new InputStreamReader(is);
            engine.eval(reader);
            return engine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Map input message to json obj => convert to string finally
     *
     * @param requestWrapper
     * @return
     */
    public String mapInputMsgToJSONStr(RequestWrapper requestWrapper) {
        String objAsStr = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputObj inputObj = new InputObj();
            inputObj.setInputMessage(requestWrapper.getMessage());
            inputObj.setComputerOutput(
                    requestWrapper.getTextBlocks().stream()
                            .filter(x -> "computerOutput".equals(x.getType()))
                            .map(DataEntity::getText)
                            .findAny().orElse(null));
            inputObj.setSourceCode(
                    requestWrapper.getTextBlocks().stream()
                            .filter(x -> "sourceCode".equals(x.getType()))
                            .map(DataEntity::getText)
                            .findAny().orElse(null));
            inputObj.setConfusionInputs(
                    requestWrapper.getTextBlocks().stream()
                            .filter(x -> "ConfusionInput".equals(x.getType()))
                            .map(DataEntity::getText)
                            .collect(Collectors.toList()));
            inputObj.setExpectedOutput(
                    requestWrapper.getTextBlocks().stream()
                            .filter(x -> "expectedOutput".equals(x.getType()))
                            .map(DataEntity::getText)
                            .findAny().orElse(null));

            objAsStr = objectMapper.writeValueAsString(inputObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objAsStr;
    }

    /**
     * Load patterns and responses from JSON file
     *
     * @return <patterns, responses>
     */
    public List<JSONObject> loadJSONFiles() {
        List<JSONObject> jsons = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new InputStreamReader(getClass().getResourceAsStream("/patterns/test.json"));
            jsons.add((JSONObject) parser.parse(reader));
            reader = new InputStreamReader(getClass().getResourceAsStream("/patterns/testResponse.json"));
            jsons.add((JSONObject) parser.parse(reader));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsons;
    }

    /**
     * Get responses array from matcher.js
     *
     * @param jsonObj
     * @param objAsStr
     * @return
     */
    public List<String> getMatchResponses(List<JSONObject> jsonObj,
                                          String objAsStr) {
        System.out.println("objAsStr => " + objAsStr);
        System.out.println("jsonObj => " + jsonObj);
        List<String> responses = new ArrayList<>();
        try {
            Invocable invocable = (Invocable) loadNashornEngine();
            ScriptObjectMirror obj = (ScriptObjectMirror)
                    invocable.invokeFunction("patternMatcher", jsonObj.get(0),
                            jsonObj.get(1), objAsStr);

            Collection<Object> values = obj.values();
            if (values.size() != 0) {
                for (Object value : values) {
                    responses.add((String) value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responses;
    }

}