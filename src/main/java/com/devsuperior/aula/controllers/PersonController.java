package com.devsuperior.aula.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.services.PersonService;

@RestController
@RequestMapping(value = "/people")
public class PersonController{
	
	@Autowired
	private PersonService service;
	

	//@PostMapping
	public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO dto) {
		dto = service.insert(dto); 
		
		//to generate the correct HTTP response code 201 - Created
		//good programming practicePost 
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@PostMapping
	public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO dto) {
		dto = service.insert(dto); 
		
		//to generate the correct HTTP response code 201 - Created
		//good programming practicePost 
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	
}

