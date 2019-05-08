package com.nu.automentor.controller;

import com.nu.automentor.model.PiazzaResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import piazza.Piazza;
import piazza.responses.contentGet.ContentGetResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
public class PiazzaController {

    private final static Piazza piazza = new Piazza();

    private final static List<String> samplePostIds = Arrays.asList(
            "27",
            "54",
            "61",
            "70",
            "71",
            "76",
            "81",
            "94",
            "102",
            "114",
            "139",
            "147",
            "188",
            "230",
            "239"
    );

    @GetMapping("/piazza")
    public String piazza(@RequestParam(defaultValue = "27") String cid,
                         @RequestParam(defaultValue = "jbzfbbon3nt32i") String nid,
                         Model model) throws IOException {

        if (!piazza.isAuthenticated()) {
            String email = System.getenv("PIAZZA_EMAIL");
            String password = System.getenv("PIAZZA_PASSWORD");
            piazza.userLogin(email, password);
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

