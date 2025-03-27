package com.example.notification;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

@Configuration
@RequiredArgsConstructor
public class ObservabilityConfig {

    private final ConcurrentKafkaListenerContainerFactory containerFactory;

    @PostConstruct
    public void setObservationForKafkaTemplate() {
        containerFactory.getContainerProperties().setObservationEnabled(true);
    }

}
