package com.example.serviceinventory.controller;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;
import com.example.serviceinventory.model.InterfaceEmpleado;
import com.example.serviceinventory.model.InterfacePerson;
import com.example.serviceinventory.model.Listas;
import com.example.serviceinventory.repositories.PersonRepository;
import com.example.serviceinventory.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private InterfacePerson personImp;
    @Autowired
    private InterfaceEmpleado empleadoImp;

    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/admin/addPerson")
    public Person addPerson(@RequestBody @Validated Person p) {
        System.out.println("control de versionamiento 1 aqui va esta version denuevo6464646");
        return personImp.save(p);
    }

    @PutMapping("/admin/updatePerson/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("id") Long id) {
        return personImp.update(person, id);
    }

    @PutMapping("/updateEmpleado/{id}")
    public Empleado addPerson(@RequestBody Empleado e, @PathVariable("id") Long id) {
        return empleadoImp.save(e, id);
    }

    @DeleteMapping("/admin/deletePerson/{id}")
    public String deletePersonById(@PathVariable("id") Long id) {
        personImp.deletePersonById(id);
        return "Empleado eliminado correctamente";
    }

    @GetMapping("/admin/listPerson")
    public List<Person> personList() {

        return personImp.personList();
    }

    @GetMapping("/admin/listEmpleadoEstadoVacunacion/{estadoVacunacion}")
    public ArrayList<Listas> findEmpleadoByEstadoVacunacion(@PathVariable("estadoVacunacion") String estadoVacunacion) {
        return empleadoImp.findEmpleadoByEstadoVacunacion(estadoVacunacion);
    }

    @GetMapping("/admin/listEmpleadoTipoVacuna/{tipoVacuna}")
    public ArrayList<Listas> findEmpleadoByTipoVacuna(@PathVariable("tipoVacuna") String tipoVacuna) {
        return empleadoImp.findEmpleadoByTipoVacuna(tipoVacuna);
    }

    @GetMapping("/admin/listEmpleadoFechaVacunacion/{fecha1}/{fecha2}")
    public ArrayList<Listas> findEmpleadoByFechas(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2) {
        return empleadoImp.findEmpleadoByFechas(fecha1, fecha2);
    }
}
