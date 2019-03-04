package com.nu.automentor.myTest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nu.automentor.model.PatternEntity;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class LoadJsonTest {

    public static void main(String args[]){
        try{
            JSONParser parser = new JSONParser();
            InputStream input = LoadJsonTest.class.getResourceAsStream("/patterns/patterns.json");
            Reader reader1 = new InputStreamReader(input);
            Object obj = parser.parse(reader1);


            JSONArray arrList = (JSONArray)obj;
            System.out.println("arrList => "+arrList);

            ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");

            InputStream is = LoadJsonTest.class.getResourceAsStream("/static/utils/matcher.js");

            Reader reader2 = new InputStreamReader(is);
            engine.eval(reader2);

            String msg = "function call: expected a function after the open parenthesis, but received #<image>.";
            //JsonObject result = getMatchResult(engine, "stringMatch", "\""+"error"+"\"", "\""+msg+"\"");

            for(int i=0; i<arrList.size(); i++){
                JSONObject gobj = (JSONObject) arrList.get(i);
                JSONObject patternsObj = (JSONObject) gobj.get("patterns");
                String patStr = patternsObj.toString();
                JsonObject result = getMatchResult(engine, "stringMatch", patStr, "\""+msg+"\"");
                System.out.println("tostring pattern => "+patStr);
                System.out.println("result = "+result);
            }


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static JsonObject getMatchResult(ScriptEngine engine, String name, String args1, String args2) throws Exception{
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
}
