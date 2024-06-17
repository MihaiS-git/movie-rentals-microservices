package ubb.movierentals.ClientEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication(exclude = RabbitAutoConfiguration.class)
public class ClientEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientEntityApplication.class, args);
	}

}
