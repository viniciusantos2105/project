 package br.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.model.Order;
import br.com.project.model.Person;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
