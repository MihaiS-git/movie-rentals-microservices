package ubb.movierentals.RentalEntity.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Value("${rabbitmq.rental.routingkey}")
    private String rentalRoutingKey;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchangeName, rentalRoutingKey, "topic important warn -> " + message);
    }
}
