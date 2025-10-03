package com.widhalm.music_manager_kafka_publisher.model;

import java.time.LocalDateTime;

public record User (
        String firstName,
        String lastName,
        String email,
        Long phoneNumber,
        Address address,
        LocalDateTime createdAt) {
    record Address (
            String city,
            String country,
            String zipcode) {
    }
}
