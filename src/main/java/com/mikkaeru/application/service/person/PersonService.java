package com.mikkaeru.application.service.person;

import com.mikkaeru.application.domain.model.Person;

public interface PersonService {

	Person create(Person person);
	
	Person update(Person person);

	void delete(Long id);
}
