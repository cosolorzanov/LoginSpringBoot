package com.example.proyectofinal.Controller;

import com.example.proyectofinal.Entity.UserEntity;
import com.example.proyectofinal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/index",""},method = RequestMethod.GET)
    ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(path = {"/register"},method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",new UserEntity());
        modelAndView.setViewName("user/register");
        return modelAndView;
    }

    @RequestMapping(path = {"/register"},method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") UserEntity userEntity){
        ModelAndView modelAndView = new ModelAndView();
        userEntity.setRolId(1);
        String au=userService.save(userEntity);
        System.out.println(au);
        return modelAndView;
    }
}