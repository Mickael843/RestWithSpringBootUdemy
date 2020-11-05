package com.mikkaeru.application.controller.person;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
		List<PersonDTO> peopleDTO = toCollection(people);
		peopleDTO.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).getPerson(p.getId())).withSelfRel()));
		return peopleDTO;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
		var personOptional = repository.findById(id);
				
		if(personOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		var personDTO = personOptional.get().convertToDTO();
		personDTO.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());
		
		return ResponseEntity.ok(personDTO);
	}
	
	@ResponseStatus(code = CREATED)
	@PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
	public PersonDTO create(@RequestBody PersonDTO person) {
		var personDTO = personService.create(person.convertToEntity()).convertToDTO();
		person.add(linkTo(methodOn(PersonController.class).getPerson(person.getId())).withSelfRel());
		
		return personDTO;
	}
	
	@PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person, @PathVariable Long id) {
		var personOptional = repository.findById(id);
		
		if (personOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		var personDTO = personOptional.get().convertToDTO();
		personDTO.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());
		
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
