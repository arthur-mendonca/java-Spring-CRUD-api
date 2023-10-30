package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Person;

@Repository
public interface personRepository extends JpaRepository<Person, Long> {
	}
