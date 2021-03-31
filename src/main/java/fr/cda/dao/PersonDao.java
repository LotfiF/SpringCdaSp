package fr.cda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.cda.entities.Person;

public interface PersonDao extends CrudRepository<Person, Long> {
	
	public List<Person> findByAge(int age);
	/*JPQL*/
	@Query(value = "SELECT p FROM Person p WHERE age <= ?1")
	public List<Person> getByAge(int age);

}
