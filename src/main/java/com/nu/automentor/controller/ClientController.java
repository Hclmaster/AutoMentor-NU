package com.nu.automentor.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nu.automentor.model.RequestWrapper;
import com.nu.automentor.model.ResponseWrapper;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import net.sf.json.JSONObject;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper requestMultipleInputs(@RequestBody RequestWrapper requestWrapper) throws Exception{

        System.out.println("what does Message look like => " + requestWrapper.getMessage());

        ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("--language=es6");

        FileReader reader = new FileReader("/Users/cathylin/Desktop/AutoMentor-NU/src/main/resources/static/utils/matcher.js");
        engine.eval(reader);

        if(engine instanceof Invocable) {
            Invocable invoke = (Invocable)engine;

            Object c = invoke.invokeFunction("stringMatch",  "[\"?x\", 1]", "[3, 1]");
            c = invoke.invokeFunction("stringMatch", "[\"?x\", 1, \"?y\"]", "[3, 1, 2]");
            c = invoke.invokeFunction("stringMatch", 1, 2);
            //c = invoke.invokeFunction("stringMatch", "{\"a\":1, \"b\":2}", "{\"b\":2, \"a\":1}");
            System.out.println(c.getClass());
            Gson gson = new Gson();
            System.out.println(gson.toJson(c));
            System.out.println("===> " + c);
        }

        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStudent(requestWrapper.getStudent());
        responseWrapper.setTextBlocks(requestWrapper.getTextBlocks());
        responseWrapper.setMessage(requestWrapper.getMessage());
        List<String> list = new ArrayList<>();
        list.add("Take a look at the examples on the pages returned by the web search with \"Racket docs beside\"");
        list.add("Take a look at the examples at https://docs.racket-lang.org/" +
                "teachpack/2htdpimage.html#%28def._%28%28lib._2htdp%2Fimage..rkt%29._beside%29%29");
        responseWrapper.setResponse(list);
        return responseWrapper;
    }
}
