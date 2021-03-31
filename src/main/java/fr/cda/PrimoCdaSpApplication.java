package fr.cda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cda.dao.PersonDao;
import fr.cda.entities.Person;

@SpringBootApplication
public class PrimoCdaSpApplication implements CommandLineRunner {
	
	@Autowired
	private PersonDao personRepo;

	public static void main(String[] args) {
		SpringApplication.run(PrimoCdaSpApplication.class, args);
		
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Lancement");
		
		Person p1 = (new Person(null, "FATHI", "Lotfi", 29));
		personRepo.save(p1);
		personRepo.save(new Person(null, "SALAA", "Rim", 26));
		
		Iterable<Person> personnes = personRepo.findAll();
		
		/*for (Person person: personnes) {
			System.out.println(person.toString());
		}*/
		
		personRepo.findAll().forEach(p-> {
			System.out.println(p.toString());
		});
		
		personRepo.findByAge(26).forEach(p-> {
			System.out.println(p.toString());
		});
		
		personRepo.getByAge(29).forEach(p-> {
			System.out.println(p.toString());
		});
		
	}

}
