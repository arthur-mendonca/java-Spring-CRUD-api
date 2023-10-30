package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Person;
import com.example.demo.repositories.personRepository;


@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	personRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding all people");
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating a person");
		
		return repository.save(person);
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding a person");		

		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records were found for this ID."));
	}
	
	public Person update(Person person) {
		logger.info("Updating a person");
		
		Person entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records were found for this ID."));
	
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
				
	} 
	
	public void delete(Long id) {
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records were found for this ID."));
		
		repository.delete(entity);
		logger.info("Deleting a person");
		
	} 
}
