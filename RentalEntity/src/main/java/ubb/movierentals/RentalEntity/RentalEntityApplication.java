package ubb.movierentals.RentalEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication(exclude = RabbitAutoConfiguration.class)
public class RentalEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalEntityApplication.class, args);
	}

}
