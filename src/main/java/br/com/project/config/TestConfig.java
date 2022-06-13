package br.com.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.enums.OrderStatus;
import br.com.project.model.Clothes;
import br.com.project.model.Order;
import br.com.project.model.Person;
import br.com.project.repositories.ClothesRepository;
import br.com.project.repositories.OrderRepository;
import br.com.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClothesRepository clothesRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Person user = new Person(null, "Vinícius", "vinicius@gmail.com", "8888888", "12345");
		Person user2 = new Person(null, "Camila", "camila@gmail.com", "9999999", "12345");
		
		Order order = new Order(null, Instant.parse("2022-06-10T10:20:05Z"), OrderStatus.CANCELED.getDescription(), user2); 
		Order order2 = new Order(null, Instant.parse("2022-06-07T08:15:05Z"), OrderStatus.PAID.getDescription(), user);
		
		Clothes clothes = new Clothes(null, 50, "Camisa Preta", 25.00, 50.00);
		Clothes clothes2 = new Clothes(null, 20, "Short Azul", 15.00, 32.00);
		Clothes clothes3 = new Clothes(null, 50, "Vestido Cinza", 18.00, 43.00);
		
		userRepository.saveAll(Arrays.asList(user, user2));
		orderRepository.saveAll(Arrays.asList(order, order2));
		clothesRepository.saveAll(Arrays.asList(clothes, clothes2, clothes3));
	}
	
	
	
}
