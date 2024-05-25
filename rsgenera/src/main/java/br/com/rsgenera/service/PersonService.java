package br.com.rsgenera.service;

import br.com.rsgenera.entity.Person;
import br.com.rsgenera.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    public Person update(Long id, Person personDetails) {
    Person person = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());
        person.setPicture(personDetails.getPicture());
        person.setStatus(personDetails.isStatus());

        return repository.save(person);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
