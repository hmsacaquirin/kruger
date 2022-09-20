package com.example.serviceinventory.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {
    public Person(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cedula")
    @NotNull
    @NotEmpty(message="La cedula es obligatoria")
    @Pattern(regexp = "[0-9]{10}+", message="La cedula solo debe tener solo numeros y un maximo de 10")
    private String cedula;
    @Column(name = "nombres")
    @NotNull
    @NotEmpty(message="Los nombres son obligatorios")
    @Pattern(regexp = "[a-zA-Z\\s]*$", message="Caracter no valido para este campo")
    private String nombres;
    @Column(name = "apellido")
    @NotNull
    @NotEmpty(message="Los apellidos son obligatorios")
    @Pattern(regexp = "[a-zA-Z\\s]*$", message="Caracter no valido para este campo")
    private String apellido;
    @Column(name = "email")
    @NotNull
    @NotEmpty(message="El email es obligatorio")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message="Email no valido")
    private String email;

}
