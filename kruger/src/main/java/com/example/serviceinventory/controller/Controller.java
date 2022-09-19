package com.example.serviceinventory.controller;

import com.example.serviceinventory.entities.Empleado;
import com.example.serviceinventory.entities.Person;
import com.example.serviceinventory.model.InterfaceEmpleado;
import com.example.serviceinventory.model.InterfacePerson;
import com.example.serviceinventory.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private InterfacePerson personImp;
    @Autowired
    private InterfaceEmpleado empleadoImp;


    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody @Validated Person p) {
        return personImp.save(p);
    }

    @PutMapping("/updatePerson/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("id") Long id) {
        return personImp.update(person, id);
    }
    @PutMapping("/updateEmpleado/{id}")
    public Empleado addPerson(@RequestBody Empleado e, @PathVariable("id") Long id) {
        return empleadoImp.save(e,id);
    }
    @DeleteMapping("/deletePerson/{id}")
    public String deletePersonById(@PathVariable("id") Long id) {
        personImp.deletePersonById(id);
        return "Empleado eliminado correctamente";
    }
    @GetMapping("/listPerson")
    public List<Person> personList()
    {

        return personImp.personList();
    }
}
