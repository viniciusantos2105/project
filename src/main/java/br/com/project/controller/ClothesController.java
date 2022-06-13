package br.com.project.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.model.Clothes;
import br.com.project.repositories.ClothesRepository;
import br.com.project.service.ClothesService;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
	
	@Autowired
	private ClothesRepository repository;
	
	@Autowired
	private ClothesService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Clothes>> findAll(){
		List<Clothes> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clothes> findById(@PathVariable Long id){
		Clothes obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping("/addClothes")
	public ResponseEntity<Clothes> saveClothe(@RequestBody Clothes clothes){
		repository.saveAll(Arrays.asList(clothes));
		return null;
	}
	
	@DeleteMapping("/deleteClothes{id}")
	public ResponseEntity<Clothes> delete(@PathVariable Long id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		return null;
	}
	
	//@DeleteMapping("/deleteClothes")
	//public ResponseEntity<Clothes> delete(@RequestBody Integer id){
	//		if(repository.existsById(id)) {
	//		repository.deleteById(id);
	//	}
	//	return null;
	//}
	
	@PatchMapping("/buy")
	public ResponseEntity<Clothes> buyClothes(@RequestBody Long id, Integer quantity){
		Clothes obj = service.buyClothes(id, quantity);
		return ResponseEntity.ok().body(obj);
	}
}
