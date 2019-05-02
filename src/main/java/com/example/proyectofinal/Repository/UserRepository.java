package com.example.proyectofinal.Repository;

import com.example.proyectofinal.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface   UserRepository extends CrudRepository<UserEntity,Long> {
}
