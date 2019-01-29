package com.nu.automentor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    // use @requestBody doesn't work.
    public ModelAndView greetingSubmit(@ModelAttribute Greeting greeting) {
        System.out.println("greeting id ==> "+greeting.getId());
        System.out.println("greeting content ==> "+greeting.getContent());
        PostResponse pr = new PostResponse();
        pr.id=(int)greeting.getId();
        pr.message=greeting.getContent();
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", pr);
        mav.setViewName("result");
        return mav;
    }

}