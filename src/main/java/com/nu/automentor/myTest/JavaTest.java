package com.nu.automentor.myTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JavaTest {
    public static void main(String[] args) throws Exception{
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        obj.put("label", "Function");
        obj.put("text", "What is function interpolate-colors?");
        obj.put("type", "ConfusionInput");
        array.add(obj);
        obj.clear();
        obj.put("label", "Parameters");
        obj.put("text", "What does weight refers to?");
        obj.put("type", "ConfusionInput");
        obj.clear();
        obj.put("label", "Parameters");
        obj.put("text", "test does weight refers to?");
        obj.put("type", "test");
        array.add(obj);
        JSONObject ans = new JSONObject();
        ans.put("textBlocks", array);
        System.out.println("ans => " + ans);
    }
}