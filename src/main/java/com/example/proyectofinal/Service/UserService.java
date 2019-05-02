package com.example.proyectofinal.Service;

import com.example.proyectofinal.Entity.UserEntity;
import com.example.proyectofinal.Repository.UserRepository;
import com.example.proyectofinal.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;



@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WebSecurityConfig webSecurityConfig;

    public void save(UserEntity userEntity){
        String passCrytp=webSecurityConfig.passwordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(passCrytp);
        userRepository.save(userEntity);
    }

    public String update(UserEntity userEntity){
        userRepository.save(userEntity);
        return "El usuario "+userEntity.getUsername()+" se ha actualizado con exito";
    }

}
