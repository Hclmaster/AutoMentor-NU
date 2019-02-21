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
import java.util.ArrayList;
import java.util.List;

import static com.nu.automentor.patterns.PatternsString.errorPatterns;

@RestController
public class ClientController {

    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper requestMultipleInputs(@RequestBody RequestWrapper requestWrapper) throws Exception{
        ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");

        FileReader reader = new FileReader("/Users/cathylin/Desktop/AutoMentor-NU/src/main/resources/static/utils/matcher.js");
        engine.eval(reader);

        // first judge whether it has error or not
        JsonObject result = getMatchResult(engine, "stringMatch", "\""+"error"+"\"", "\""+requestWrapper.getMessage()+"\"");

        List<DataEntity> dataList = requestWrapper.getTextBlocks();
        for(int i=0; i<dataList.size(); i++){
            DataEntity data = dataList.get(i);
            System.out.println("label => "+data.getLabel());
            System.out.println("text => "+data.getText());
            System.out.println("type => "+data.getType());
        }

        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStudent(requestWrapper.getStudent());
        responseWrapper.setTextBlocks(requestWrapper.getTextBlocks());
        responseWrapper.setMessage(requestWrapper.getMessage());

        List<String> list = new ArrayList<>();

        // If there is no error, response "give me error msg"
        if(result.size() == 0){
            list.add("Please give me your error message!");
        }else{
            String[] errPatterns = errorPatterns;

            for(int i=0; i<dataList.size(); i++){
                DataEntity data = dataList.get(i);
                for(int j=0; j<errPatterns.length; j++){
                    System.out.println("errPatterns => " + errPatterns[j]);
                    JsonObject errorMatchResult = getMatchResult(engine, "stringMatch", errPatterns[j], "\""+data.getText()+"\"");
                    System.out.println("regex matches result => " + errorMatchResult);

                    if(errorMatchResult.size() != 0){
                        String functionName = extractFunctionName(engine, "stringMatch", errorMatchResult);
                    }
                }
            }

            // original hardcoded part
            list.add("Take a look at the examples on the pages returned by the web search with \"Racket docs beside\"");
            list.add("Take a look at the examples at https://docs.racket-lang.org/" +
                    "teachpack/2htdpimage.html#%28def._%28%28lib._2htdp%2Fimage..rkt%29._beside%29%29");
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

    public String extractFunctionName(ScriptEngine engine, String name, JsonObject errorMatchResult){
        String extractFunctionPattern = "{\"reg\": \"function (\\w*){1}\"}";
        return null;
    }
}
