package com.example.proyectofinal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.example.proyectofinal.Entity.RolEntity;

import java.util.Optional;

@Component()
public interface RolRepository extends CrudRepository<RolEntity,Long> {

    public Optional<RolEntity> findById(int id);
}
