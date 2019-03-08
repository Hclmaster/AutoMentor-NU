package com.nu.automentor.myTest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MatcherTest {
    public static void main(String args[]) throws Exception{
        ScriptEngine engine = loadNashornEngine();
        String requestStr = "function overlay is not defined even though I have imported all the required packages";
        //requestStr = "get error message “function call: expected a function after the open parenthesis, but received #<image>.” when call (beside (a-red-square) (a-blue-square) (a-green-square))";
        JSONArray arrList = loadJSONFile();

        for(int i=0; i<arrList.size(); i++){
            JSONObject obj = (JSONObject) arrList.get(i);
            System.out.println("arrList[i] => " + obj);
            String errorPattern = obj.get("patterns").toString();
            JsonObject result = getMatchResult(engine, "stringMatch", errorPattern, "\"" + requestStr + "\"");
            System.out.println("result => " + result);
            System.out.println("result size => " + result.size());
            if(result.size() != 0){
                JsonObject resultObj = result.get("0").getAsJsonObject();
                System.out.println("get result value => " + resultObj.get("?x"));
                String name = resultObj.get("?x").getAsString();
                System.out.println("how about this one???? " + name);
            }
        }
    }

    public static ScriptEngine loadNashornEngine() {
        try {
            ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");
            InputStream is = MatcherTest.class.getResourceAsStream("/static/utils/matcher.js");
            Reader reader = new InputStreamReader(is);
            engine.eval(reader);
            return engine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray loadJSONFile() {
        try {
            JSONParser parser = new JSONParser();
            InputStream input = LoadJsonTest.class.getResourceAsStream("/patterns/patterns.json");
            Reader reader = new InputStreamReader(input);
            Object obj = parser.parse(reader);
            JSONArray arrList = (JSONArray) obj;
            return arrList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonObject getMatchResult(ScriptEngine engine, String name, String args1, String args2) throws Exception {
        if (engine instanceof Invocable) {
            Invocable invoke = (Invocable) engine;
            Object c = invoke.invokeFunction(name, args1, args2);
            //JSONObject obj = (JSONObject) c;

            Gson gson = new Gson();
            String jsonStr = gson.toJson(c);
            JsonParser parser = new JsonParser();
            JsonElement je = parser.parse(jsonStr);
            JsonObject result = je.getAsJsonObject();

            return result;
        }
        return null;
    }


}
