package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.models.Person;


@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		List<Person> persons = new ArrayList<>();
		
		for ( int i = 0; i<= 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		logger.info("Finding all people");
		return persons;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person First Name " + i);
		person.setLastName("Person Last Name " + i);
		person.setAddress("Person Address " + i);
		person.setGender("Person gender " + i);

		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating a person");
		
		return person;
	}
	
	public Person findById(String id) {
		
		logger.info("Finding a person");
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Arthur");
		person.setLastName("Mendonça");
		person.setAddress("Juiz de Fora/MG");
		person.setGender("Male");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating a person");
		
		return person;
	} 
	
	public void delete(String id) {
		logger.info("Deleting a person");
		
	} 
}
