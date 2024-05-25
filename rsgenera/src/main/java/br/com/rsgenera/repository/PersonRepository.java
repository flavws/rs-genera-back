package br.com.rsgenera.repository;

import br.com.rsgenera.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
