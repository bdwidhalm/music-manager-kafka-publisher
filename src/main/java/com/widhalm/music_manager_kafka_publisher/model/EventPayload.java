package com.widhalm.music_manager_kafka_publisher.model;

import com.widhalm.music_manager_kafka_publisher.config.EventType;

public record EventPayload(EventType eventType, String payload) {
}
