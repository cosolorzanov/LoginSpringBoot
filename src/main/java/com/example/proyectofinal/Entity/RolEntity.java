package com.example.proyectofinal.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rol", schema = "mydb", catalog = "")
public class RolEntity {
    private int id;
    private String name;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolEntity rolEntity = (RolEntity) o;
        return id == rolEntity.id &&
                Objects.equals(name, rolEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
