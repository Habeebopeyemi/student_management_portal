package com.example.student_management_portal.controllers;

import com.example.student_management_portal.services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
public class AuthenticationController {
    @Autowired
    private AuthenticationServices authService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getLandingPage(){
       ModelAndView landingPage = new ModelAndView();
       landingPage.setViewName("portal/index");
        return landingPage;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignupPage(){
        ModelAndView signupPage = new ModelAndView();
        signupPage.setViewName("portal/signup");
        return signupPage;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView getSigninPage(){
        ModelAndView signinPage = new ModelAndView();
        signinPage.setViewName("portal/signin");
        return signinPage;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, @RequestParam(value = "repeatPassword") String repeatPassword){
        ModelAndView loginView = new ModelAndView();
        authService.createAdmin(email, password);
        loginView.setViewName("portal/signin");
        return loginView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password){
        boolean response = authService.getAdmin(email, password);
        ModelAndView responsePage;
        if(response){
            return "redirect:/student/allStudents";
        }else{
            responsePage = new ModelAndView();
            responsePage.setViewName("portal/signin");
            responsePage.addObject("error", true);
            responsePage.addObject("message","Invalid username or password");
        }
        return responsePage;
    }
}
