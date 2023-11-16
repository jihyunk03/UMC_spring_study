package umc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJayApplication.class, args);
	}

}
