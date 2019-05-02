package com.example.proyectofinal.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserEntityPK implements Serializable {
    private int id;
    private int rolId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Rol_id")
    @Id
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityPK that = (UserEntityPK) o;
        return id == that.id &&
                rolId == that.rolId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rolId);
    }
}
