package com.example.serviceinventory.model;

import com.example.serviceinventory.entities.Person;

import java.util.List;

public interface InterfacePerson {
    Person save(Person person);
    Person update(Person person, Long id);
    void deletePersonById(Long id);
    List<Person> personList();
}
