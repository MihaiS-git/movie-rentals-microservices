package ubb.movierental.MovieEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ubb.movierental.MovieEntity.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/sender")
    public String producer(@RequestBody String message) {
            rabbitMQSender.send(message);
            return "Message sent to the RabbitMQ Queue Successfully";
    }
}
