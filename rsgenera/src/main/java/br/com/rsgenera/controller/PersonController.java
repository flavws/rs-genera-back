package br.com.rsgenera.controller;

import br.com.rsgenera.entity.Person;
import br.com.rsgenera.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        try {
            Person person = personService.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
            return ResponseEntity.ok(person);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        try {
            Person personUpdated = personService.update(id, person);
            return ResponseEntity.ok(personUpdated);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerfil(@PathVariable Long id) {
        try {
            personService.findById(id).orElseThrow();
            personService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
