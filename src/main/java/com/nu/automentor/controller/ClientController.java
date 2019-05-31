package com.nu.automentor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nu.automentor.model.*;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ClientController {

    @CrossOrigin
    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper getResponses
            (@RequestBody RequestWrapper requestWrapper) throws Exception {
        String objAsStr = mapInputMsgToJSONStr(requestWrapper);
        List<JSONObject> jsonObj = loadJSONFiles();

        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStudent(requestWrapper.getStudent());
        responseWrapper.setTextBlocks(requestWrapper.getTextBlocks());
        responseWrapper.setMessage(requestWrapper.getMessage());
        List<List<String>> patAndResp = getMatchResponses(jsonObj, objAsStr);
        responseWrapper.setResponse(patAndResp.get(1));
        JSONParser parser = new JSONParser();
        if(patAndResp.get(0).size() > 0) {
            String patStr = patAndResp.get(0).get(0);
            JSONObject patObj = (JSONObject) parser.parse(patStr);
            responseWrapper.setPatternsObj(patObj);
            responseWrapper.setDiagnosis((String) patObj.get("diagnosis"));
        }else responseWrapper.setPatternsObj(null);
        return responseWrapper;
    }

    /**
     * Load Nashorn Engine to read JS file
     *
     * @return
     */
    private ScriptEngine loadNashornEngine() {
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
    private String mapInputMsgToJSONStr(RequestWrapper requestWrapper) {
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
            inputObj.setStuckInput(
                    requestWrapper.getTextBlocks().stream()
                    .filter(x -> "StuckInput".equals(x.getType()))
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
    private List<JSONObject> loadJSONFiles() {
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
    private List<List<String>> getMatchResponses(List<JSONObject> jsonObj,
                                                 String objAsStr) {
        System.out.println("objAsStr => " + objAsStr);
        List<List<String>> patResp = new ArrayList<>();
        List<String> responses = new ArrayList<>();
        List<String> pats = new ArrayList<>();
        try {
            Invocable invocable = (Invocable) loadNashornEngine();
            assert invocable != null;
            ScriptObjectMirror obj = (ScriptObjectMirror)
                    invocable.invokeFunction("patternMatcher", jsonObj.get(0),
                            jsonObj.get(1), objAsStr);

            Collection<Object> values = obj.values();
            if (values.size() != 0) {
                for (Object value : values) {
                    String[] ans = value.toString().split("\\{", 2);
                    responses.add(ans[0].substring(0, ans[0].length()-1));
                    pats.add("{" + ans[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Remove duplicated patterns
        List<String> patsWithoutDuplicates = pats.stream().distinct().collect(Collectors.toList());
        patResp.add(patsWithoutDuplicates);
        patResp.add(responses);
        return patResp;
    }

}