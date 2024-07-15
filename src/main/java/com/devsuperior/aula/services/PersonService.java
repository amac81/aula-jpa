package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;


@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;

	@Autowired
	private DepartmentRepository departmentRepository;
	
		
	@Transactional
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		Person entity = new Person(); 
		copyDtoToEntity(dto, entity);		

		entity = repository.save(entity);
		
		return new PersonDepartmentDTO(entity);
	}
		
	private void copyDtoToEntity(PersonDepartmentDTO dto, Person entity) {
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		//Department dept = new Department();	
		//dept.setId(dto.getDepartment().getId());
		
		Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
		
		
		
		entity.setDepartment(dept);
	}

}