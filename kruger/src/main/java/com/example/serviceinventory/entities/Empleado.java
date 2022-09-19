package com.example.serviceinventory.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;
    @Column(name = "direccion_domicilio")
    private String direccion_domicilio;
    @Column(name = "celular")
    private String celular;
    @Column(name = "estado_vacunacion")
    private  String estado_vacunacion;
    @Column(name = "tipo_vacuna")
    private  String tipo_vacuna;
    @Column(name = "fecha_vacunacion")
    private  String fecha_vacunacion;
    @Column(name = "numero_dosis")
    private  Long numero_dosis;
    @Column(name = "id_person")
    private Long id_person;

}
