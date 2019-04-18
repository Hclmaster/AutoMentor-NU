package com.nu.automentor.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nu.automentor.model.DataEntity;
import com.nu.automentor.model.RequestWrapper;
import com.nu.automentor.model.ResponseWrapper;
import com.nu.automentor.myTest.LoadJsonTest;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.nu.automentor.patterns.PatternsString.*;

@RestController
public class ClientController {

    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper requestMultipleInputs(@RequestBody RequestWrapper requestWrapper) throws Exception {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStudent(requestWrapper.getStudent());
        responseWrapper.setTextBlocks(requestWrapper.getTextBlocks());
        responseWrapper.setMessage(requestWrapper.getMessage());

        ScriptEngine engine = loadNashornEngine();

        String[] categoryReg = {"{\"reg\":  \"error\"}", "{\"reg\":  \"(confused|how .*? use|[W|w]hat(.*)?[is|to])\"}"};
        String[] category = {"error", "confused"};

        List<DataEntity> textList = requestWrapper.getTextBlocks();
        List<String> list = new ArrayList<>();

        // load patterns from JSON file
        JSONObject patObj = loadJSONFile();

        for (int i = 0; i < categoryReg.length; i++) {
            System.out.println("categoryReg[i] => " + categoryReg[i]);
            JsonObject result = getMatchResult(engine, "stringMatch", categoryReg[i], "\"" + requestWrapper.getMessage() + "\"");
            //JsonObject result = getMatchResult(engine, "stringMatch", "\"" + categoryReg[i] + "\"", "\"" + requestWrapper.getMessage() + "\"");
            System.out.println("result => " + result);
            if (result.size() != 0) {
                String functionName = null;
                JSONArray arrList = (JSONArray) patObj.get(category[i]);
                for (int j = 0; j < textList.size(); j++) {
                    DataEntity data = textList.get(j);
                    for (int k = 0; k < arrList.size(); k++) {
                        JSONObject obj = (JSONObject) arrList.get(k);
                        String errorPattern = obj.get("patterns").toString();
                        JsonObject errorMatchResult = getMatchResult(engine, "stringMatch", errorPattern, "\"" + data.getText() + "\"");
                        System.out.println("errorPattern => " + errorPattern);
                        System.out.println("errorMatchResult => " + errorMatchResult);
                        if (errorMatchResult.size() != 0) {
                            JsonObject functionNameObj = errorMatchResult.get("0").getAsJsonObject();
                            JSONArray responses = (JSONArray) obj.get("response");
                            responseWrapper.setPatternsObj(errorPattern);
                            if (functionNameObj.size() == 0) {
                                for (int l = 0; l < responses.size(); l++) {
                                    list.add(responses.get(l).toString());
                                }
                            } else {
                                for (int l = 0; l < responses.size(); l++) {
                                    String response = responses.get(l).toString();
                                    for (Iterator iterator = functionNameObj.keySet().iterator(); iterator.hasNext();){
                                        String key = (String) iterator.next();
                                        functionName = functionNameObj.get(key).toString();
                                        response = response.replaceAll("\\"+key, functionName);
                                    }
                                    list.add(response);
                                }
                            }
                        }
                    }
                }
                break;
            }
        }

        if (list.size() == 0) {
            list.add("Please give me your request message!");
        }

        responseWrapper.setResponse(list);
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
     * Load patterns from JSON file
     *
     * @return
     */
    public JSONObject loadJSONFile() {
        try {
            JSONParser parser = new JSONParser();
            InputStream input = LoadJsonTest.class.getResourceAsStream("/patterns/patterns.json");
            Reader reader = new InputStreamReader(input);
            JSONObject obj = (JSONObject) parser.parse(reader);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Call matcher.js to get the match result
     *
     * @param engine
     * @param name
     * @param args1
     * @param args2
     * @return
     * @throws Exception
     */
    public JsonObject getMatchResult(ScriptEngine engine, String name, String args1, String args2) throws Exception {
        if (engine instanceof Invocable) {
            Invocable invoke = (Invocable) engine;
            Object c = invoke.invokeFunction(name, args1, args2);

            Gson gson = new Gson();
            String jsonStr = gson.toJson(c);
            JsonParser parser = new JsonParser();
            JsonElement je = parser.parse(jsonStr);
            JsonObject result = je.getAsJsonObject();

            return result;
        }
        return null;
    }

    /**
     * Extract the function name if needed (somewhat hardcoded... need to improve...)
     *
     * @param engine
     * @param name
     * @param errorMessageText
     * @return
     * @throws Exception
     */
    public String extractFunctionName(ScriptEngine engine, String name, String errorMessageText) throws Exception {
        String[] extractFunctionPattern = funcPatterns;
        String functionName = null;

        for (int i = 0; i < extractFunctionPattern.length; i++) {
            //System.out.println("extractFuncPattern => " + extractFunctionPattern[i]);
            JsonObject matchResult = getMatchResult(engine, name, extractFunctionPattern[i], "\"" + errorMessageText + "\"");
            JsonElement je = matchResult.get("0");
            //System.out.println("je ==> " + je);
            if (je != null) {
                String str = je.getAsJsonObject().get("0").getAsString();
                if (i == 0) functionName = str.substring(1);
                if (i == 1) functionName = str.substring(0, str.indexOf(':'));
                if (i == 2) functionName = str.substring(9);
                if (i == 3) functionName = str.substring(0, str.indexOf(" not"));
            }
            //System.out.println("functionName => " + functionName);
            if (functionName != null) return functionName;
        }
        return functionName;
    }
}
