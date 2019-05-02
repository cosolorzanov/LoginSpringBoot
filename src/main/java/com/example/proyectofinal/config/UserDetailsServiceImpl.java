package com.example.proyectofinal.config;

import java.util.ArrayList;
import java.util.List;

import com.example.proyectofinal.Entity.RolEntity;
import com.example.proyectofinal.Entity.UserEntity;
import com.example.proyectofinal.Repository.UserRepository;
import com.example.proyectofinal.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import  com.example.proyectofinal.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RolRepository rolRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        UserEntity appUser =
                userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        //Mapear nuestra lista de Authority con la de spring security
        List grantList = new ArrayList();
        RolEntity rolEntity = rolRepository.findById(appUser.getRolId()).orElseThrow(()->new NotFoundException("el rol no existe"));
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rolEntity.getName());
        grantList.add(grantedAuthority);

        //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
        return user;
    }
}