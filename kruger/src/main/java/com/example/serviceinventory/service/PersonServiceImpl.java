package com.example.serviceinventory.service;

import com.example.serviceinventory.entities.Person;
import com.example.serviceinventory.entities.User;
import com.example.serviceinventory.model.InterfacePerson;
import com.example.serviceinventory.repositories.PersonRepository;
import com.example.serviceinventory.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements InterfacePerson {
    @Autowired
    private PersonRepository personRepositori;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Person save(Person person) {
        Person p1=personRepositori.save(person);
        User u=new User();
        u.setUsername(p1.getCedula());
        u.setPassword(p1.getCedula());
        u.setIdPerson(p1.getId());
        usuarioRepository.save(u);
        return p1;
    }

    @Override
    public Person update(Person person, Long id) {
        Person pe = personRepositori.findById(id).get();
        if (Objects.nonNull(person.getCedula())
                && !"".equalsIgnoreCase(
                person.getCedula())) {
            pe.setCedula(person.getCedula());
        }

        if (Objects.nonNull(
                person.getNombres())
                && !"".equalsIgnoreCase(
                person.getNombres())) {
            pe.setNombres(
                    person.getNombres());
        }
        if (Objects.nonNull(
                person.getApellido())
                && !"".equalsIgnoreCase(
                person.getApellido())) {
            pe.setApellido(
                    person.getApellido());
        }
        if (Objects.nonNull(person.getEmail()) && !"".equalsIgnoreCase(person.getEmail())) {
            pe.setEmail(person.getEmail());
        }

        return personRepositori.save(pe);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepositori.deleteById(id);
    }

    @Override
    public List<Person> personList() {
        return  personRepositori.findAll();
    }
}
