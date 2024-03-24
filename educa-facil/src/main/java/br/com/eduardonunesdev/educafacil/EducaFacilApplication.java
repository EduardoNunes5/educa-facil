package br.com.eduardonunesdev.educafacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EducaFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducaFacilApplication.class, args);
	}

}
