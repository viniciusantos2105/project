package br.com.project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.entites.Person;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@GetMapping("/")
	public ResponseEntity<Person> findAll(){
		Person user = new Person(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(user);
	}
}
