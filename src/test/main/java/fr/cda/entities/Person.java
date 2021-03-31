package fr.cda.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Person {
	
	@Id
	private Long id;
	
	private String nom;
	
	private String preom;
	
	private int age;
	

}
