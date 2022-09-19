package com.example.serviceinventory.service;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;
import com.example.serviceinventory.entities.User;
import com.example.serviceinventory.model.InterfaceEmpleado;
import com.example.serviceinventory.model.InterfacePerson;
import com.example.serviceinventory.model.Listas;
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

    @Override
    public Empleado save(Empleado empleado, Long id) {
        Empleado emp = empleadoRepository.findPersonByIdPerson(id);
        Empleado e = new Empleado();
        if (emp == null) {
            if (empleado.getEstado_vacunacion().equals("Vacunado")) {
                e.setFecha_nacimiento(empleado.getFecha_nacimiento());
                e.setDireccion_domicilio(empleado.getDireccion_domicilio());
                e.setCelular(empleado.getCelular());
                e.setEstado_vacunacion(empleado.getEstado_vacunacion());
                e.setTipo_vacuna(empleado.getTipo_vacuna());
                e.setFecha_vacunacion(empleado.getFecha_vacunacion());
                e.setNumero_dosis(empleado.getNumero_dosis());
                e.setId_person(id);
            }
            if (empleado.getEstado_vacunacion().equals("No Vacunado")) {
                e.setFecha_nacimiento(empleado.getFecha_nacimiento());
                e.setDireccion_domicilio(empleado.getDireccion_domicilio());
                e.setCelular(empleado.getCelular());
                e.setEstado_vacunacion(empleado.getEstado_vacunacion());
                e.setId_person(id);
            }
            return empleadoRepository.save(e);
        } else {
            Empleado empR = empleadoRepository.findById(emp.getId()).get();
            if (empR.getEstado_vacunacion().equals("Vacunado")) {
                if (Objects.nonNull(empleado.getFecha_nacimiento())
                        && !"".equalsIgnoreCase(
                        empleado.getFecha_nacimiento())) {
                    empR.setFecha_nacimiento(empleado.getFecha_nacimiento());
                }
                if (Objects.nonNull(empleado.getDireccion_domicilio())
                        && !"".equalsIgnoreCase(
                        empleado.getDireccion_domicilio())) {
                    empR.setDireccion_domicilio(empleado.getDireccion_domicilio());
                }
                if (Objects.nonNull(empleado.getCelular())
                        && !"".equalsIgnoreCase(
                        empleado.getCelular())) {
                    empR.setCelular(empleado.getCelular());
                }
                if (Objects.nonNull(empleado.getTipo_vacuna())
                        && !"".equalsIgnoreCase(
                        empleado.getTipo_vacuna())) {
                    empR.setTipo_vacuna(empleado.getTipo_vacuna());
                }
                if (Objects.nonNull(empleado.getFecha_vacunacion())
                        && !"".equalsIgnoreCase(
                        empleado.getFecha_vacunacion())) {
                    empR.setFecha_vacunacion(empleado.getFecha_vacunacion());
                }
                if (Objects.nonNull(empleado.getNumero_dosis())) {
                    empR.setNumero_dosis(empleado.getNumero_dosis());
                }
                empR.setEstado_vacunacion(empR.getEstado_vacunacion());
                empR.setId_person(empR.getId_person());
            }
            if (empR.getEstado_vacunacion().equals("No Vacunado")) {
                if (Objects.nonNull(empleado.getFecha_nacimiento())
                        && !"".equalsIgnoreCase(
                        empleado.getFecha_nacimiento())) {
                    empR.setFecha_nacimiento(empleado.getFecha_nacimiento());
                }
                if (Objects.nonNull(empleado.getDireccion_domicilio())
                        && !"".equalsIgnoreCase(
                        empleado.getDireccion_domicilio())) {
                    empR.setDireccion_domicilio(empleado.getDireccion_domicilio());
                }
                if (Objects.nonNull(empleado.getCelular())
                        && !"".equalsIgnoreCase(
                        empleado.getCelular())) {
                    empR.setCelular(empleado.getCelular());
                }
                empR.setEstado_vacunacion(empR.getEstado_vacunacion());
                empR.setId_person(empR.getId_person());
            }
            return empleadoRepository.save(empR);
        }
    }

    @Override
    public List findEmpleadoByEstadoVacunacion(String estadoVacunacion) {
        return empleadoRepository.findEmpleadoByEstadoVacunacion(estadoVacunacion);
    }

    @Override
    public List findEmpleadoByTipoVacuna(String tipoVacuna) {
        return empleadoRepository.findEmpleadoByTipoVacuna(tipoVacuna);
    }

    @Override
    public List findEmpleadoByFechas(String fecha1, String fecha2) {
        return empleadoRepository.findEmpleadoByFechas(fecha1, fecha2);
    }
}
