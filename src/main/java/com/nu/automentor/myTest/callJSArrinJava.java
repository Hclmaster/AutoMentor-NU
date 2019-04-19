package com.nu.automentor.myTest;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.text.Element;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;

public class callJSArrinJava {
    public static void main(String args[]){
        double[] srcC = new double[] { 1.141, 1.12, 1.331, 1.44, 1.751, 1.66, 1.971, 1.88, 1.191, 1.101 };
        double[] output = {};
        try {
            ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");

            InputStream is = callJSArrinJava.class.getResourceAsStream("/static/utils/test.js");
            Reader reader = new InputStreamReader(is);
            engine.eval(reader);

            Invocable invocable = (Invocable) engine;

            ScriptObjectMirror obj = (ScriptObjectMirror) invocable.invokeFunction("avg", srcC, 2);

            Collection<Object> values = obj.values();
            if (values.size() == 0) {
                System.out.println("output => " + output);
            }
            output = new double[values.size()];
            int i = 0;
            for (Iterator<Object> iterator = values.iterator(); iterator.hasNext();) {
                Object value = iterator.next();
                if (value instanceof Double) {
                    Double object = (Double) value;
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
