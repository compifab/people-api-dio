package com.compifab.peopleapi.controller;

import com.compifab.peopleapi.dto.MessageResponseDTO;
import com.compifab.peopleapi.dto.request.PersonDTO;
import com.compifab.peopleapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService PersonService) {
        this.personService = PersonService;
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}
