 package br.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.entites.Person;

public interface UserRepository extends JpaRepository<Person, Long> {

}
