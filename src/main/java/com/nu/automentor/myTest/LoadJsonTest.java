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
import java.util.*;

public class LoadJsonTest {

    public static void main(String args[]){
        try {
            List<String> ans = new ArrayList<String>();
            ans.add("This is list one!");
            ans.add("This is list two");
            System.out.println("ans list => " + ans);
            String dataText = "What the difference between ordinary, tail and iterative recursion?";
            ans = addResourceResponse(dataText, ans);
            System.out.println("ans list => " + ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Judge whether there is key in the json file contained in the msg.
     * @param msg
     * @return
     */
    public static List<String> addResourceResponse(String msg, List<String> li) {
        try {
            JSONParser parser = new JSONParser();
            InputStream input = LoadJsonTest.class.getResourceAsStream("/patterns/response.json");
            Reader reader = new InputStreamReader(input);
            JSONObject jsonObj = (JSONObject) parser.parse(reader);
            jsonObj.keySet().forEach(key -> {
                if(msg.contains((String)key)){
                    JSONArray keyValue = (JSONArray) jsonObj.get(key);
                    //System.out.println("keyValue => " + keyValue);

                    for(int i=0; i<keyValue.size(); i++){
                        li.add((String)keyValue.get(i));
                    }
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
        return li;
    }
}
