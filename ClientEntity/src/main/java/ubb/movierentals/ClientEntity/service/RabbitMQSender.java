package ubb.movierentals.ClientEntity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Value("${rabbitmq.client.routingkey}")
    private String clientRoutingKey;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchangeName, clientRoutingKey, "topic important warn -> " + message);
    }
}
