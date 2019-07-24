package com.example.repository;

import com.example.model.entity.Person;

import java.util.List;

public interface PersonRepository {

    //save or update
    Person save(Person p);
    void delete(Person p);
    List<Person> findAll();
    Person findById(Long id);

}
