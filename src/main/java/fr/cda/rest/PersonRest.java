package fr.cda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cda.dao.PersonDao;
import fr.cda.entities.Person;

@RestController
public class PersonRest {
	
	@Autowired
	private PersonDao personRepo;
	
	@GetMapping("/user")
	public Iterable<Person> getAllPerson() {
		return personRepo.findAll();
	}

}
