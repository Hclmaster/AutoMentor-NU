package com.nu.automentor.controller;

import com.nu.automentor.model.RequestWrapper;
import com.nu.automentor.model.ResponseWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @RequestMapping(value = "/api/form", method = RequestMethod.POST)
    public ResponseWrapper requestMultipleInputs(@RequestBody RequestWrapper requestWrapper){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setStu(requestWrapper.getStu());
        responseWrapper.setDataLst(requestWrapper.getDataLst());
        List<String> list = new ArrayList<>();
        list.add("Take a look at the examples on the pages returned by the web search with \"Racket docs beside\"");
        list.add("Take a look at the examples at https://docs.racket-lang.org/" +
                "teachpack/2htdpimage.html#%28def._%28%28lib._2htdp%2Fimage..rkt%29._beside%29%29");
        responseWrapper.setResponse(list);
        return responseWrapper;
    }
}
