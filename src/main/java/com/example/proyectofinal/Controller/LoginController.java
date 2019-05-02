package com.example.proyectofinal.Controller;

import com.example.proyectofinal.Entity.UserEntity;
import com.example.proyectofinal.Repository.UserRepository;
import com.example.proyectofinal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@SuppressWarnings("PackageAccessibility")
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @RequestMapping(path = {"/index",""},method = RequestMethod.GET)
    public ModelAndView home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userRepository.findByUsername(auth.getName()).orElseThrow(()-> new UsernameNotFoundException(null));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(path = {"/register"},method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",new UserEntity());
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        UserEntity user =userRepository.findByUsername(auth.getName()).orElse(null);
        if (user==null)
            modelAndView.setViewName("register");
        else
            modelAndView.setViewName("error");

        return modelAndView;
    }

    @RequestMapping(path = {"/register"},method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid  @ModelAttribute("user") UserEntity userEntity, BindingResult result){
        ModelAndView modelAndView = new ModelAndView();

        if(result.hasErrors())
            modelAndView.setViewName("user/register");
        else{
            userEntity.setRolId(1);
            userEntity.setEnabled((byte)1);
            userService.save(userEntity);
            //modelAndView.setViewName("user/user");
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }
    @RequestMapping(path = {"/login"},method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false)String error,
                                  @RequestParam(value = "logout", required = false)String logout, HttpServletRequest servletRequest){

        String errorMessge=null;

        if(error != null) {
            errorMessge = "El usuario o la contraseña son incorrectos !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessge",errorMessge);

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        UserEntity user =userRepository.findByUsername(auth.getName()).orElse(null);
        //UserEntity user =userRepository.findByUsername(auth.getName()).orElse(null);
        if (user==null)
            modelAndView.setViewName("login");
        else
            modelAndView.setViewName( "error");
        return modelAndView;
    }

    @RequestMapping(path="/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/login?logout=true");
        return modelAndView;
    }

    @RequestMapping(path = "/accesoDenegado", method = RequestMethod.GET)
    public ModelAndView AccesoDenegado(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}