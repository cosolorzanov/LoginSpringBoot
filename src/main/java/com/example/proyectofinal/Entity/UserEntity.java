package com.example.proyectofinal.Entity;

import com.example.proyectofinal.Validation.Password;
import com.example.proyectofinal.Validation.UniqueEmail;
import com.example.proyectofinal.Validation.UniqueUsername;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "mydb", catalog = "")
@IdClass(UserEntityPK.class)
public class UserEntity {
    private int id;

    @NotBlank(message = "espacio requerido")
    private String name;

    @Column(unique = true,name = "username")

    @Size(min = 4,max = 45,message = "el usuario debe tener por lo menos 4 caracteres y maximo 45")
    @UniqueUsername(message = "nombre de usuario no disponible")
    private String username;

    @Column(unique = true,name = "email")
    @Email(message = "email incorrecto")
    @UniqueEmail(message = "El correo ya está asociado a una cuenta")
    private String email;

    @Size(min=8,max=45,message = "debe tener como minimo 8 caracteres y como maximo 45 ")
    @Password(message="La contraseña debe tener por lo menos un numero, una letra minuscula y una mayuscula ")
    private String password;

    @NotNull(message = "espacio requerido")
    private Integer phone;
    private int rolId;
    private Byte enabled;
    private RolEntity rolByRolId;

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

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Id
    @Column(name = "Rol_id")
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Basic
    @Column(name = "enabled")
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                rolId == that.rolId &&
                Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, password, phone, rolId, enabled);
    }

    /*@ManyToOne
    @JoinColumn(name = "Rol_id", referencedColumnName = "id", nullable = false)
    public RolEntity getRolByRolId() {
        return rolByRolId;
    }*/

    public void setRolByRolId(RolEntity rolByRolId) {
        this.rolByRolId = rolByRolId;
    }
}
