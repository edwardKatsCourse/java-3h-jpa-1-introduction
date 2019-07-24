package com.example.controller;

import com.example.model.dto.PersonRequest;
import com.example.model.dto.PersonResponse;
import com.example.model.entity.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RestController
public class PersonController {

    //Registration
    //RegistrationController

    //@Transactional
    //RegistrationService

    //UsersRepository -> Users,
    //UserInfoRepository -> UserInfo,
    //UserCredentialsRepository -> UserCredentials,
    //UserAccountRepository -> UserAccount,
    //UserSessionRepository -> UserSession

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public PersonResponse save(@RequestBody PersonRequest personRequest) {
        Person person = Person.builder()
                .name(personRequest.getName())
                .dateOfBirth(personRequest.getDateOfBirth())
                .email(personRequest.getEmail())
                .phoneNumber(personRequest.getPhoneNumber())
                .build();

        personRepository.save(person);

        return convert(person);
    }


    @GetMapping("/persons/{id}")
    public PersonResponse findById(@PathVariable("id") Long id) {
        Person person = personRepository.findById(id);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with such id [" + id + "] does not exist");
        }

        return convert(person);
    }

    @GetMapping("/persons")
    public List<PersonResponse> findAll() {
        return personRepository.findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/persons/{id}")
    public void delete(@PathVariable("id") Long id) {
        Person person = personRepository.findById(id);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with such id [" + id + "] does not exist");
        }

        personRepository.delete(person);
    }

    private PersonResponse convert(Person person) {
        return PersonResponse
                .builder()
                .name(person.getName())
                .dateOfBirth(person.getDateOfBirth())
                .id(person.getId())
                .build();
    }
}
