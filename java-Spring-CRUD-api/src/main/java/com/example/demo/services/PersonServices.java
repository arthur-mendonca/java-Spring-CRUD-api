package com.example.demo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.example.demo.PersonController;
import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.data.vo.v2.PersonVOv2;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.ModelMapperUtil;
import com.example.demo.mapper.custom.PersonMapper;
import com.example.demo.models.Person;
import com.example.demo.repositories.personRepository;


@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	personRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people");
		return ModelMapperUtil.parseListObjects(repository.findAll(), PersonVO.class); 
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating a person");
		
		var entity = ModelMapperUtil.parseObject(person, Person.class);
		var vo =  ModelMapperUtil.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOv2 createV2(PersonVOv2 person) {
		logger.info("Creating a v2 person ");
		
		var entity = mapper.convertVoToEntity(person);
		var vo =  mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO findById(Long id) throws Exception {
		
		logger.info("Finding a person");		

		var entity =  repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records were found for this ID."));
		
		PersonVO vo = ModelMapperUtil.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating a person");
		
		Person entity = repository.findById(person.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("No records were found for this ID."));
	
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo =  ModelMapperUtil.parseObject(repository.save(entity), PersonVO.class);
		return vo;
				
	} 
	
	public void delete(Long id) {
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records were found for this ID."));
		
		repository.delete(entity);
		logger.info("Deleting a person");
		
	} 
}
