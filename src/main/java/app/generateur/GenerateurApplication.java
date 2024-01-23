package app.generateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("app.generateur.entity")
public class GenerateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateurApplication.class, args);
	}
}
