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
	
	@GetMapping("/user/{id}")
	public Optional<Person> getById(@PathVariable Long id) {
		return personRepo.findById(id);
	}
	
	@PostMapping("/user")
	public Person savePerson(@RequestBody Person p) {
		return personRepo.save(p);
	}
	
	@DeleteMapping("/user/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		if(personRepo.findById(id).isPresent()) {
			personRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PutMapping("/user/{id}")
	public Person modifPerson(@RequestBody Person p, @PathVariable Long id) {
			p.setId(id);
			return personRepo.save(p);
		}
	

}
