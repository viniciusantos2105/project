package br.com.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.entites.Person;
import br.com.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Person user = new Person(null, "Vinícius", "vinicius@gmail.com", "8888888", "12345");
		Person user2 = new Person(null, "Camila", "camila@gmail.com", "9999999", "12345");
		
		userRepository.saveAll(Arrays.asList(user, user2));
	}
	
}
