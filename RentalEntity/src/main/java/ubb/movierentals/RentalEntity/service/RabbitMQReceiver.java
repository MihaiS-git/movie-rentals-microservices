package ubb.movierentals.RentalEntity.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitMQReceiver {
    private static final Logger log = LogManager.getLogger(RabbitMQReceiver.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "${rabbitmq.client.queue}")
    public void receiveMessageFromClientQueue(String message) {
        log.info("Received message from client queue: {}", message);
        extracted("Client: " + message);
    }

    @RabbitListener(queues = "${rabbitmq.movie.queue}")
    public void receiveMessageFromMovieQueue(String message) {
        log.info("Received message from movie queue: {}", message);
        extracted("Movie: " + message);
    }

    private void extracted(String message) {
        try {
            Map<String, String> messageMap = new HashMap<>();
            messageMap.put("message", message);
            String messageJson = objectMapper.writeValueAsString(messageMap);
            messagingTemplate.convertAndSend("/topic/rentalmessage", messageJson);
            log.info("Sent message to topic: {}", messageJson);
        } catch (Exception e) {
            log.error("Error converting message to JSON", e);
        }
    }
}
