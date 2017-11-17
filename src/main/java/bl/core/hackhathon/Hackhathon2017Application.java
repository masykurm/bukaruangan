package bl.core.hackhathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="bl.core")
@EnableAutoConfiguration
public class Hackhathon2017Application {

	public static void main(String[] args) {
		SpringApplication.run(Hackhathon2017Application.class, args);
	}
}
