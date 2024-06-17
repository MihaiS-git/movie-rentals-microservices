package ubb.movierental.MovieEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication(exclude = RabbitAutoConfiguration.class)
public class MovieEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieEntityApplication.class, args);
	}

}
