package com.nu.automentor.controller;

import com.nu.automentor.model.DataEntity;
import com.nu.automentor.model.RequestWrapper;
import com.nu.automentor.model.ResponseWrapper;
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

        String[] categoryReg = {"{\"reg\":  \"error|n't defined\"}", "{\"reg\":  \"(confused|how .*? use|[W|w]hat(.*)?[is|to])\"}",
                "{\"reg\": \"[H|h]ow to.*|stuck|[S|s]tuck\"}"};
        String[] category = {"error", "confused", "stuck"};

        List<DataEntity> textList = requestWrapper.getTextBlocks();
        List<String> list = new ArrayList<>();
        List<String> patterns = new ArrayList<>();

        // load patterns from JSON file
        JSONObject patObj = loadJSONFile();
        Invocable invocable = (Invocable) engine;

        // Add all possible response resources first
        List<List<String>> ans = addResourceResponse(requestWrapper.getMessage(), list, patterns);
        list = ans.get(0);
        patterns = ans.get(1);

        for (int i = 0; i < categoryReg.length; i++) {
            ScriptObjectMirror obj = (ScriptObjectMirror) invocable.invokeFunction("stringMatch",
                                                                                    categoryReg[i], "\"" + requestWrapper.getMessage() + "\"", null);
            Collection<Object> values = obj.values();
            if (values.size() != 0) {
                System.out.println("category => " + category[i]);
                JSONArray arrList = (JSONArray) patObj.get(category[i]);
                if (textList.size() == 0) {
                    list.add("Show me what you've tried, what's actually happening?");
                    patterns.add("None Patterns");
                    ans = addPatternResponse(arrList, invocable, requestWrapper.getMessage(), list, patterns);
                    list = ans.get(0);
                    patterns = ans.get(1);
                    break;
                }
                for (int j = 0; j < textList.size(); j++) {
                    DataEntity data = textList.get(j);
                    System.out.println("dataText => " + data.getText());
                    ans = addPatternResponse(arrList, invocable, data.getText(), list, patterns);
                    list = ans.get(0);
                    patterns = ans.get(1);
                }
            }
        }

        if (list.size() == 0) {
            list.add("Please give me your request message!");
            patterns.add("None Patterns");
        }

        System.out.println("list => "  + list);
        System.out.println("patterns => " + patterns);

        responseWrapper.setResponse(list);
        responseWrapper.setPatternsObj(patterns);
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
            InputStream input = getClass().getResourceAsStream("/patterns/patterns.json");
            Reader reader = new InputStreamReader(input);
            JSONObject obj = (JSONObject) parser.parse(reader);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Judge whether there is key in the json file contained in the msg.
     *
     * @param msg
     * @return
     */
    public List<List<String>> addResourceResponse(String msg, List<String> li, List<String> patterns) {
        List<List<String>> ans  = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            InputStream input = getClass().getResourceAsStream("/patterns/response.json");
            Reader reader = new InputStreamReader(input);
            JSONObject jsonObj = (JSONObject) parser.parse(reader);
            jsonObj.keySet().forEach(key -> {
                if (msg.toLowerCase().contains((String) key)) {
                    JSONArray keyValue = (JSONArray) jsonObj.get(key);
                    for (int i = 0; i < keyValue.size(); i++) {
                        li.add((String) keyValue.get(i));
                        patterns.add("None Patterns.");
                    }
                }
            });
            ans.add(li);
            ans.add(patterns);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    public List<List<String>> addPatternResponse(JSONArray arrList,
                                           Invocable invocable,
                                           String text,
                                           List<String> list,
                                           List<String> patterns) throws Exception {
        List<List<String>> ans  = new ArrayList<>();

        for (int i = 0; i < arrList.size(); i++) {
            JSONObject obj2 = (JSONObject) arrList.get(i);
            String errorPattern = obj2.get("patterns").toString();
            JSONArray responses = (JSONArray) obj2.get("response");
            String[] resp = new String[responses.size()];
            for (int l = 0; l < responses.size(); l++) resp[l] = (String) responses.get(l);
            ScriptObjectMirror matchResult = (ScriptObjectMirror) invocable.invokeFunction("stringMatch",
                                                                                            errorPattern, "\"" + text + "\"", resp);
            Collection<Object> matchValues = matchResult.values();
            if (matchValues.size() != 0) {
                for (Iterator<Object> iterator = matchValues.iterator(); iterator.hasNext(); ) {
                    Object value = iterator.next();
                    if (value instanceof String) {
                        list.add((String) value);
                        patterns.add(errorPattern);
                    }
                }
            }
        }

        ans.add(list);
        ans.add(patterns);
        return ans;
    }

}