package com.example.student_management_portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Portal")
public class authenticationController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getLandingPage(){
       ModelAndView landingPage = new ModelAndView();
       landingPage.setViewName("/portal/index");
        return landingPage;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignupPage(){
        ModelAndView signupPage = new ModelAndView();
        signupPage.setViewName("/portal/signup");
        return signupPage;
    }
}
