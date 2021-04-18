package com.compifab.peopleapi.service;

import com.compifab.peopleapi.dto.MessageResponseDTO;
import com.compifab.peopleapi.dto.request.PersonDTO;
import com.compifab.peopleapi.entity.Person;
import com.compifab.peopleapi.mapper.PersonMapper;
import com.compifab.peopleapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person savedPerson = personMapper.toModel(personDTO);
        personRepository.save(savedPerson);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
