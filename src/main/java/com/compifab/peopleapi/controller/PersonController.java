package com.compifab.peopleapi.controller;

import com.compifab.peopleapi.dto.MessageResponseDTO;
import com.compifab.peopleapi.entity.Person;
import com.compifab.peopleapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService PersonService) {
        this.personService = PersonService;
    }

    @GetMapping
    public String getBook() {
        return "Hello my best friend!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
