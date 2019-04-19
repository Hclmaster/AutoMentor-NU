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
import jdk.nashorn.api.scripting.ScriptObjectMirror;
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
import java.util.Collection;
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

        String[] categoryReg = {"{\"reg\":  \"error\"}", "{\"reg\":  \"(confused|how .*? use|[W|w]hat(.*)?[is|to])\"}",
                                "{\"reg\": \"[H|h]ow to.*|stuck\"}"};
        String[] category = {"error", "confused", "stuck"};

        List<DataEntity> textList = requestWrapper.getTextBlocks();
        List<String> list = new ArrayList<>();

        // load patterns from JSON file
        JSONObject patObj = loadJSONFile();
        Invocable invocable = (Invocable) engine;

        for (int i = 0; i < categoryReg.length; i++) {
            ScriptObjectMirror obj = (ScriptObjectMirror) invocable.invokeFunction("stringMatch", categoryReg[i], "\"" + requestWrapper.getMessage() + "\"", null);
            Collection<Object> values = obj.values();
            if (values.size() != 0) {
                JSONArray arrList = (JSONArray) patObj.get(category[i]);
                if(textList.size() == 0){
                    list.add("Show me what you've tried, what's actually happening?");
                    break;
                }
                for (int j = 0; j < textList.size(); j++) {
                    DataEntity data = textList.get(j);
                    System.out.println("dataText => " + data.getText());
                    for (int k = 0; k < arrList.size(); k++) {
                        JSONObject obj2 = (JSONObject) arrList.get(k);
                        String errorPattern = obj2.get("patterns").toString();
                        JSONArray responses = (JSONArray) obj2.get("response");
                        String[] resp = new String[responses.size()];
                        for(int l = 0; l < responses.size(); l++) resp[l] = (String)responses.get(l);
                        ScriptObjectMirror matchResult = (ScriptObjectMirror) invocable.invokeFunction("stringMatch", errorPattern, "\"" + data.getText() + "\"", resp);
                        Collection<Object> matchValues = matchResult.values();

                        if (matchValues.size() != 0) {
                            responseWrapper.setPatternsObj(errorPattern);
                            for (Iterator<Object> iterator = matchValues.iterator(); iterator.hasNext();) {
                                Object value = iterator.next();
                                if (value instanceof String) {
                                    list.add((String)value);
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

}
