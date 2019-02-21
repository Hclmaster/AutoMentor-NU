package com.nu.automentor.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternsString {
    public static String[] errorPatterns = {
            "{\"reg\": \"(.*) is not defined\"}",
            "{\"reg\": \"expect.*but\"}"
    };

    public static List<String> notDefinedResponse = Arrays.asList(
            "There is a non-existent ?x referenced somewhere.",
            "Take a look at ?x documentation."
    );

    public static List<String> expectButResponse = Arrays.asList(
            "Take a look at Racket Syntax Documentation."
    );

    public static ArrayList<List<String>> responseSentences = new ArrayList<List<String>>(){{
        add(notDefinedResponse);
        add(expectButResponse);
    }};



    public static void main(String[] args){
        System.out.println(errorPatterns.length);
        for(int i=0; i<errorPatterns.length; i++){
            System.out.println(errorPatterns[i]);
        }
        System.out.println("=====================>");
        for(int i=0; i<responseSentences.size(); i++){
            List<String> li = responseSentences.get(i);
            for(int j=0; j<li.size(); j++){
                System.out.println(li.get(j));
            }
        }
    }
}
