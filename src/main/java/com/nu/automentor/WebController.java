package com.nu.automentor;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @RequestMapping("/sample")
    public PostResponse Sample(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        PostResponse response = new PostResponse();
        response.setId(1);
        response.setMessage("Your name is "+name);
        return response;

    }

    @RequestMapping(value = "/test", method =   RequestMethod.POST)
    public PostResponse Test(@RequestBody PostRequest inputPayload) {
        PostResponse response = new PostResponse();
        response.setId(inputPayload.getId()*100);
        response.setMessage("Hello " + inputPayload.getName());
        response.setExtra("Some text");
        return response;
    }
}
