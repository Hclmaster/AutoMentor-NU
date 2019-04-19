package com.nu.automentor.myTest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nu.automentor.model.PatternEntity;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import net.sf.json.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class LoadJsonTest {

    public static void main(String args[]){
        try {
            String[] output = {};
            ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");

            InputStream is = LoadJsonTest.class.getResourceAsStream("/static/utils/matcher.js");
            Reader reader = new InputStreamReader(is);
            engine.eval(reader);

            Invocable invocable = (Invocable) engine;

            String errorPattern = "{\"reg\": \"the difference between (.*) and ([^\\\\?]+)\", \"pats\": [\"?x\", \"?y\"]}";
            String dataText = "What the difference between ordinary, tail and iterative recursion?";
            //dataText = "abc";
            /*ArrayList<String> resp = new ArrayList<String>();
            resp.add("Try to search with the difference between ?x and ?y");*/
            String[] resp = new String[1];
            resp[0] = "Try to search with the difference between ?x and ?y";

            //double[] srcC = new double[] { 1.141, 1.12, 1.331, 1.44, 1.751, 1.66, 1.971, 1.88, 1.191, 1.101 };

            ScriptObjectMirror obj = (ScriptObjectMirror) invocable.invokeFunction("stringMatch", errorPattern, "\"" + dataText + "\"", resp);
            Collection<Object> values = obj.values();
            System.out.println("values size => " + values.size());
            if (values.size() == 0) {
                System.out.println("output =>  null!");
            }
            output = new String[values.size()];
            int i = 0;
            for (Iterator<Object> iterator = values.iterator(); iterator.hasNext();) {
                Object value = iterator.next();
                if (value instanceof String) {
                    String object = (String) value;
                    output[i] = object;
                    i++;
                }
            }
            for (int j=0; j<output.length; j++){
                System.out.println(output[j]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
