package com.mikkaeru.application.service.person.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikkaeru.application.domain.model.Person;
import com.mikkaeru.application.repository.PersonRepository;
import com.mikkaeru.application.service.person.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository Repository;
	
	@Override
	public Person create(Person person) {
		return Repository.save(person);
	}
	
	@Override
	public Person update(Person person) {
		return Repository.save(person);
	}
	
	@Override
	public void delete(Long id) {
		Repository.deleteById(id);
	}
	
}
