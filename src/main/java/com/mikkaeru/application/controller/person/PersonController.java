package com.mikkaeru.application.controller.person;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mikkaeru.application.domain.model.Person;
import com.mikkaeru.application.repository.PersonRepository;
import com.mikkaeru.application.service.person.PersonService;
import com.mikkaeru.application.tdo.PersonDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Person EndPoint", description = "description for person", tags = {"PersonEndpoint"})
@RestController
@RequestMapping(value = "/v1/person", produces = APPLICATION_JSON_VALUE)
public class PersonController {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("")
	@ResponseStatus(OK)
	public List<PersonDTO> getPeople() {
		var people = repository.findAll();
		return toCollection(people);
	}
	
	@ApiOperation(value = "Find One person by id")
	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
		var personOptional = repository.findById(id);
				
		if(personOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(personOptional.get().convertToDTO());
	}
	
	@ResponseStatus(code = CREATED)
	@PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
	public PersonDTO create(@RequestBody PersonDTO person) {
		return personService.create(person.convertToEntity()).convertToDTO();
	}
	
	@PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person, @PathVariable Long id) {
		var personOptional = repository.findById(id);
		
		if (personOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(personService.update(person.convertToEntity()).convertToDTO());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		var personOptional = repository.findById(id);
		
		if (personOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	private List<PersonDTO> toCollection(List<Person> people) {
		return people.stream().map(p -> p.convertToDTO()).collect(Collectors.toList());
	}
}
