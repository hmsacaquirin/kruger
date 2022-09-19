package com.example.serviceinventory.model;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;

import java.util.List;

public interface InterfaceEmpleado {
    Empleado save(Empleado empleado, Long id);

    List findEmpleadoByEstadoVacunacion(String estadoVacunacion);

    List findEmpleadoByTipoVacuna(String tipoVacuna);

    List findEmpleadoByFechas(String fecha1, String fecha2);
}
