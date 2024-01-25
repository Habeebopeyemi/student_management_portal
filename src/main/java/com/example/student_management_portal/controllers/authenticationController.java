package com.example.student_management_portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
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

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView getSigninPage(){
        ModelAndView signinPage = new ModelAndView();
        signinPage.setViewName("/portal/signin");
        return signinPage;
    }
}
