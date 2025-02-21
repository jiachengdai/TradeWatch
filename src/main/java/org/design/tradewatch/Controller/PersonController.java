package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Person;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")

public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Result<List<Person>> getAllPersons() {
        return Result.success(personRepository.findAll());
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
