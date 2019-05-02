package com.example.proyectofinal.Service;

import com.example.proyectofinal.Entity.UserEntity;
import com.example.proyectofinal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
   private UserRepository userRepository;

    public List<UserEntity> finAll() {
        List<UserEntity> list;
        list = (List<UserEntity>) userRepository.findAll();
        return list;
    }

    public UserEntity findById(long id) {
        for (UserEntity user:finAll() ) {
            if (user.getId()==id)
                return user;
        }
        return null;
    }

    public UserEntity findByUsername(String Username) {
        for (UserEntity user:finAll() ) {
            if (user.getUsername().equals(Username))
                return user;
        }
        return null;
    }

    public String save(UserEntity userEntity){
        userRepository.save(userEntity);
        return "El usuario "+userEntity.getUsername()+" se ha creado con exito";
    }
    public String update(UserEntity userEntity){
        userRepository.save(userEntity);
        return "El usuario "+userEntity.getUsername()+" se ha actualizado con exito";
    }
}
