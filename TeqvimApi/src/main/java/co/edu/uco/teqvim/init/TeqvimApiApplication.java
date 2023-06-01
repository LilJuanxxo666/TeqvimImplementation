package co.edu.uco.teqvim.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"co.edu.uco.teqvim"})
public class TeqvimApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeqvimApiApplication.class, args);
	}

}
