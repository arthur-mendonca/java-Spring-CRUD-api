package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.data.vo.v2.PersonVOv2;
import com.example.demo.services.PersonServices;
import com.example.demo.util.MediaType;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	
	@GetMapping(value = "/{key}", 
			produces = {MediaType.APPLICATION_JSON, 
						MediaType.APPLICATION_XML,
						MediaType.APPLICATION_YML})
	public PersonVO findById(@PathVariable(value = "key") Long key) throws Exception {
		return service.findById(key);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	public List<PersonVO> findAll() throws Exception {
		return service.findAll();
	}
	
	@PostMapping( consumes = {
							MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML}, 
			produces = {MediaType.APPLICATION_JSON, 
						MediaType.APPLICATION_XML,
						MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return service.create(person);
	}
	@PostMapping(value="/v2", consumes = {
									MediaType.APPLICATION_JSON, 
									MediaType.APPLICATION_XML,
									MediaType.APPLICATION_YML}, 
				produces = {
						MediaType.APPLICATION_JSON, 
						MediaType.APPLICATION_XML,
						MediaType.APPLICATION_YML})
	public PersonVOv2 createV2(@RequestBody PersonVOv2 person) throws Exception {
		return service.createV2(person);
	}
	@PutMapping(value = "/{key}",
			consumes = {
					MediaType.APPLICATION_JSON, 
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML},
			produces = {
					MediaType.APPLICATION_JSON, 
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public PersonVO update(@PathVariable(value="key") Long key, @RequestBody PersonVO person) throws Exception {
		person.setKey(key);
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{key}")
	public ResponseEntity<?> delete(@PathVariable(value = "key") Long key) throws Exception {
		service.delete(key);
		return ResponseEntity.noContent().build();
	}
		
}
