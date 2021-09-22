package com.sathsaraw.demo.controller;

import com.sathsaraw.demo.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/person")
public class PersonController {

    private static final List<Person> PERSONS = Arrays.asList(
      new Person(1,"Sathsara Warushawithana"),
      new Person(2, "Maria Jones"),
      new Person(3, "Anna Smith")
    );

    @GetMapping("{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer personId){

        Person foundPerson = PERSONS.stream()
                .filter(person -> personId.equals(person.getId()) )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Person " + personId + " does not exists"));
        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }
}
