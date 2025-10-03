package com.widhalm.music_manager_kafka_publisher.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.widhalm.music_manager_kafka_publisher.config.ApplicationConfiguration;
import com.widhalm.music_manager_kafka_publisher.config.EventType;
import com.widhalm.music_manager_kafka_publisher.model.EventPayload;
import com.widhalm.music_manager_kafka_publisher.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TestService {

    @Autowired
    private ApplicationConfiguration appConfig;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(User user, EventType eventType) {
        System.out.println("Publishing to topic: " + appConfig.getTopicName());
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            System.out.println("Random Message... " + dtf.format(now));
            kafkaTemplate.send(appConfig.getTopicName(), dtf.format(now));
            System.out.println("Published!");
        } catch (Exception exception) {
            System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * ");
            System.out.println("EXCEPTION occurred while publishing: " + exception.getMessage());
            System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * ");

        }
    }
}
