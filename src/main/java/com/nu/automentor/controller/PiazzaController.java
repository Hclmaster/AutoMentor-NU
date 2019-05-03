package com.nu.automentor.controller;

import com.nu.automentor.model.PiazzaResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import piazza.Piazza;
import piazza.models.ContentGetResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
public class PiazzaController {

    private final static Piazza piazza = new Piazza();

    private final static List<String> samplePostIds = Arrays.asList("54",
            "71",
            "76",
            "61",
            "81",
            "94",
            "102",
            "114",
            "147",
            "188",
            "230",
            "239",
            "70",
            "139",
            "27");

    @GetMapping("/piazza")
    public String piazza(@RequestParam(defaultValue = "432") String cid,
                         @RequestParam(defaultValue = "jbzfbbon3nt32i") String nid,
                         Model model) throws IOException {

        if (!piazza.isAuthenticated()) {
            piazza.userLogin("jeffreyholm2019@u.northwestern.edu", "automentor");
        }

        ContentGetResponse contentGetResponse = piazza.contentGet(cid, nid);

        PiazzaResponse response = new PiazzaResponse();
        response.setCid(cid);
        response.setNid(nid);
        response.setPost(contentGetResponse);
        response.setSamplePostIds(samplePostIds);

        model.addAttribute("response", response);

        return "piazza";
    }
}

