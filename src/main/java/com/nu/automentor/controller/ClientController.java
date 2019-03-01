package com.nu.automentor.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nu.automentor.model.DataEntity;
import com.nu.automentor.model.RequestWrapper;
import com.nu.automentor.model.ResponseWrapper;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
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
import java.util.List;

import static com.nu.automentor.patterns.PatternsString.*;

@RestController
public class ClientController {

    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper requestMultipleInputs(@RequestBody RequestWrapper requestWrapper) throws Exception{
        ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");

        InputStream is = getClass().getResourceAsStream("/static/utils/matcher.js");

        Reader reader1 = new InputStreamReader(is);
        engine.eval(reader1);

        // first judge whether it has error or not
        JsonObject result = getMatchResult(engine, "stringMatch", "\""+"error"+"\"", "\""+requestWrapper.getMessage()+"\"");

        List<DataEntity> dataList = requestWrapper.getTextBlocks();

        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStudent(requestWrapper.getStudent());
        responseWrapper.setTextBlocks(requestWrapper.getTextBlocks());
        responseWrapper.setMessage(requestWrapper.getMessage());

        List<String> list = new ArrayList<>();

        if(result.size() == 0){
            // If there is no error, response "give me error msg"
            list.add("Please give me your error message!");
        }else{
            String[] errPatterns = errorPatterns;
            String[] extractFunctionPattern = funcPatterns;

            String functionName = null;

            //requestWrapper.setMessage("Run (interpolate-colors blue red 0.5) and get error message that says blue: this variable is not defined.");
            //requestWrapper.setMessage("get error message \\\"overlay/xy: expects only 4 arguments, but found 11.\\\"");
            System.out.println("Message => " + requestWrapper.getMessage());

            functionName = extractFunctionName(engine, "stringMatch", requestWrapper.getMessage());

            System.out.println("At first the functionName in Message is => " + functionName);

            for(int i=0; i<dataList.size(); i++){
                DataEntity data = dataList.get(i);
                for(int j=0; j<errPatterns.length; j++){
                    JsonObject errorMatchResult = getMatchResult(engine, "stringMatch", errPatterns[j], "\""+data.getText()+"\"");
                    System.out.println("regex matches result => " + errorMatchResult);

                    if(errorMatchResult.size() != 0){
                        String tmpName = extractFunctionName(engine, "stringMatch", data.getText());
                        if(tmpName == null) tmpName = functionName;

                        ArrayList<List<String>> responseLst = responseSentences;
                        for(int k=0; k<responseLst.get(j).size(); k++){
                            String response = responseLst.get(j).get(k);
                            list.add(response.replaceAll("\\?x", tmpName));
                        }
                    }
                }
            }

        }
        responseWrapper.setResponse(list);
        return responseWrapper;
    }

    public JsonObject getMatchResult(ScriptEngine engine, String name, String args1, String args2) throws Exception{
        if(engine instanceof Invocable) {
            Invocable invoke = (Invocable)engine;

            Object c = invoke.invokeFunction(name, args1, args2);

            Gson gson = new Gson();
            String jsonStr = gson.toJson(c);
            JsonParser parser = new JsonParser();
            JsonElement je = parser.parse(jsonStr);
            JsonObject result =je.getAsJsonObject();

            return result;
        }
        return null;
    }

    public String extractFunctionName(ScriptEngine engine, String name, String errorMessageText) throws Exception{
        String[] extractFunctionPattern = funcPatterns;
        String functionName = null;

        for(int i=0; i<extractFunctionPattern.length; i++){
            System.out.println("extractFuncPattern => "+extractFunctionPattern[i]);
            JsonObject matchResult = getMatchResult(engine, name, extractFunctionPattern[i], "\""+errorMessageText+"\"");
            JsonElement je = matchResult.get("0");
            System.out.println("je ==> "+je);
            if(je != null) {
                String str = je.getAsJsonObject().get("0").getAsString();
                if(i==0) functionName = str.substring(1);
                if(i==1) functionName = str.substring(0, str.indexOf(':'));
                if(i==2) functionName = str.substring(9);
            }
            System.out.println("functionName => "+functionName);
            if(functionName != null) return functionName;
        }
        return functionName;
    }
}
