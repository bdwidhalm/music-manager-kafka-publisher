package com.widhalm.music_manager_kafka_publisher.controller;

import com.widhalm.music_manager_kafka_publisher.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.widhalm.music_manager_kafka_publisher.model.User;

import static com.widhalm.music_manager_kafka_publisher.config.EventType.USER_CREATED_EVENT;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTest(@RequestBody User user) {
        System.out.println();
        System.out.println("POST call received...");
        System.out.println();
        testService.publishMessage(user, USER_CREATED_EVENT);
    }
}
