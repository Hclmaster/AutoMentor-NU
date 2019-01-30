package com.nu.automentor.myTest;

import com.nu.automentor.myTest.Greeting;
import com.nu.automentor.myTest.PostResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public ModelAndView greetingSubmit(@ModelAttribute Greeting greeting) {
        // System.out.println("greeting id ==> "+greeting.getId());
        // System.out.println("greeting content ==> "+greeting.getContent());
        PostResponse pr = new PostResponse();
        pr.setId((int)greeting.getId());
        pr.setMessage(greeting.getContent());
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", pr);
        mav.setViewName("result");
        return mav;
    }
}