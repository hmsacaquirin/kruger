package com.example.serviceinventory.service;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;
import com.example.serviceinventory.entities.User;
import com.example.serviceinventory.model.InterfaceEmpleado;
import com.example.serviceinventory.model.InterfacePerson;
import com.example.serviceinventory.repositories.EmpleadoRepository;
import com.example.serviceinventory.repositories.PersonRepository;
import com.example.serviceinventory.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmpleadoServiceImpl implements InterfaceEmpleado {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private PersonRepository personRepository;
    @Override
    public Empleado save(Empleado empleado, Long id) {
        //Empleado emp = empleadoRepository.findById(id).get();
        //if(emp==null){
            Empleado e=new Empleado();
            if(empleado.getEstado_vacunacion().equals("Vacunado")){
                e.setFecha_nacimiento(empleado.getFecha_nacimiento());
                e.setDireccion_domicilio(empleado.getDireccion_domicilio());
                e.setCelular(empleado.getCelular());
                e.setEstado_vacunacion(empleado.getEstado_vacunacion());
                e.setTipo_vacuna(empleado.getTipo_vacuna());
                e.setFecha_vacunacion(empleado.getFecha_vacunacion());
                e.setNumero_dosis(empleado.getNumero_dosis());
                e.setId_person(id);
            }
            if(empleado.getEstado_vacunacion().equals("No Vacunado")){
                e.setFecha_nacimiento(empleado.getFecha_nacimiento());
                e.setDireccion_domicilio(empleado.getDireccion_domicilio());
                e.setCelular(empleado.getCelular());
                e.setEstado_vacunacion(empleado.getEstado_vacunacion());
                e.setId_person(id);
            }
            return  empleadoRepository.save(e);
        //}
        //return null;
    }
}
