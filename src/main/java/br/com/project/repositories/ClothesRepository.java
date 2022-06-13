 package br.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.model.Clothes;
import br.com.project.model.Person;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {

}
