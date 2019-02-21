package com.nu.automentor.patterns;

import net.sf.json.JSON;

import java.util.ArrayList;

public class ErrorPatterns {
    public static String[] errorPatterns = {
            "{\"reg\": \"(.*) is not defined\"}",
            "{\"reg\": \"expect.*but\"}"
    };

    public static void main(String[] args){
        System.out.println(errorPatterns.length);
        for(int i=0; i<errorPatterns.length; i++){
            System.out.println(errorPatterns[i]);
        }
    }
}
