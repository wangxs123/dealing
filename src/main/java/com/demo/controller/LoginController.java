package com.demo.controller;

import com.sun.xml.internal.ws.api.model.MEP;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView page(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.html");
        return mv;
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public @ResponseBody  String login(HttpServletRequest request, HttpServletResponse response){
        String userName = null;
        String passWord = null;
        userName = request.getParameter("userName");
        passWord = request.getParameter("userPassWord");
        System.out.println(userName+passWord);
        return "hello spring boot ";
    }
}
