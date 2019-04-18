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
        String response = " ?x and ?y";
        String vx = response.substring(1,3);
        System.out.println("vx => " + vx);
        //vx.replaceAll("//?", "\\\\?");
        System.out.println("vx => " + vx);
        System.out.println("response => " + response.replaceAll("\\"+vx, "a"));
    }
}
