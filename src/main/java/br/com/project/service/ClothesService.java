package br.com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project.model.Clothes;
import br.com.project.model.Order;
import br.com.project.repositories.ClothesRepository;
import br.com.project.repositories.OrderRepository;




@Service
public class ClothesService {
	@Autowired
	private ClothesRepository repository;
	
	public List<Clothes> findAll(){
		return repository.findAll();
	}
	
	public Clothes findById(Long id) {
		Optional<Clothes> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Clothes buyClothes(Long id, Integer quantity){
		Optional<Clothes> obj = repository.findById(id);
		if(obj != null && obj.get().getQuantity() >= quantity) {
			obj.get().setQuantity(quantity -= obj.get().getQuantity());
			return obj.get();
		}
		else {
			return null;
		}
	}	
}
