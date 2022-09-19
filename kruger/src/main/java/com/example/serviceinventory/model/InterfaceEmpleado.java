package com.example.serviceinventory.model;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;

import java.util.List;

public interface InterfaceEmpleado {
    Empleado save(Empleado empleado, Long id);
}
