 package br.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.entites.Order;
import br.com.project.entites.Person;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
