package com.example.serviceinventory.model;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceEmpleado {
    Empleado save(Empleado empleado, Long id);

    ArrayList<Listas> findEmpleadoByEstadoVacunacion(String estadoVacunacion);

    ArrayList<Listas> findEmpleadoByTipoVacuna(String tipoVacuna);

    ArrayList<Listas> findEmpleadoByFechas(String fecha1, String fecha2);
}
