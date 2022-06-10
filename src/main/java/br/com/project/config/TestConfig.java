package br.com.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.entites.Order;
import br.com.project.entites.Person;
import br.com.project.repositories.OrderRepository;
import br.com.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Person user = new Person(null, "Vinícius", "vinicius@gmail.com", "8888888", "12345");
		Person user2 = new Person(null, "Camila", "camila@gmail.com", "9999999", "12345");
		
		Order order = new Order(null, Instant.parse("2022-06-10T10:20:05Z"), user2); 
		Order order2 = new Order(null, Instant.parse("2022-06-07T08:15:05Z"), user);
		
		
		userRepository.saveAll(Arrays.asList(user, user2));
		orderRepository.saveAll(Arrays.asList(order, order2));
	}
	
	
	
}
