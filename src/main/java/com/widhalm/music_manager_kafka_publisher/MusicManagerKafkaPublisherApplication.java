package com.widhalm.music_manager_kafka_publisher;

import com.widhalm.music_manager_kafka_publisher.config.ApplicationConfiguration;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class MusicManagerKafkaPublisherApplication {

    @Autowired
    private ApplicationConfiguration appConfig;

    public static void main(String[] args) {
		SpringApplication.run(MusicManagerKafkaPublisherApplication.class, args);
	}

//    @Bean
//    NewTopic testTopic() {
//        return TopicBuilder.name(appConfig.getTopicName())
//                .partitions(1)
//                .replicas(1)
//                .build();
//    }

}
