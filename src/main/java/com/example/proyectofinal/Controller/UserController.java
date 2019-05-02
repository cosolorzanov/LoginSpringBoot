package com.example.proyectofinal.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/user"})
public class UserController {

    @RequestMapping(path = {""},method = RequestMethod.GET)
    public ModelAndView viewUser(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication aut= SecurityContextHolder.getContext().getAuthentication();
        String username= aut.getName();
        modelAndView.addObject("username",username);
        modelAndView.setViewName("user/user");
        return modelAndView;
    }
}
