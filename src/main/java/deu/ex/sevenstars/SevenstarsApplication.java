package deu.ex.sevenstars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SevenstarsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SevenstarsApplication.class, args);
	}

}
