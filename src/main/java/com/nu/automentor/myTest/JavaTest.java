package com.nu.automentor.myTest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaTest {
    public static void main(String[] args){
        JSONObject obj = new JSONObject();
        obj.put("0", "{}");
        System.out.println(obj);
        System.out.println(obj.size());

        JSONObject obj2 = new JSONObject();
        System.out.println(obj2);
        System.out.println(obj2.size());

        // convert String to JSONObject
        String jsonObj = "{\"0\":{}}";
        JsonParser parser = new JsonParser();
        JsonElement je = parser.parse(jsonObj);

        System.out.println("je => " + je);

        JsonObject result =je.getAsJsonObject();
        System.out.println("result => " + result);
        System.out.println("result size => " + result.size());

        System.out.println(result.get("0"));

        System.out.println("====================>");
        String ss = "{\"0\":{\"0\":\"function overlay is not defined\",\"1\":\"function overlay\",\"index\":0,\"input\":\"function overlay is not defined even though I have imported all the required packages\"}}";
        je = parser.parse(ss);
        result = je.getAsJsonObject();
        System.out.println("result2 => " + result.get("0"));
        System.out.println("result2 size => " + result.entrySet());
        Map<String, Object> attributes = new HashMap<String, Object>();
        Set<Map.Entry<String, JsonElement>> entrySet = result.entrySet();
        for(Map.Entry<String,JsonElement> entry : entrySet){
            attributes.put(entry.getKey(), result.get(entry.getKey()));
            System.out.println("key => "+entry.getKey()+" value => "+result.get(entry.getKey()));
            je = result.get(entry.getKey());
            result = je.getAsJsonObject();
            System.out.println("??? result => " + result.get("0"));
        }

    }
}
