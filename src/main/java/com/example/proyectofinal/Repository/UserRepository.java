package com.example.proyectofinal.Repository;

import com.example.proyectofinal.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("UserRepository")
public interface   UserRepository extends CrudRepository<UserEntity,Long> {
    public Optional<UserEntity> findByUsername(String username);
    public boolean existsByEmail(String email);
    public boolean existsByUsername(String username);
}
