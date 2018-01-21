package heapstark.service.kafkaService.impl;

import heapstark.service.kafkaService.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/21.
 */
@Service
public class KafkaProducerImpl implements KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.producer.topic}")
    private String topic;

    public void sendDefaultTopic(String message) {
        kafkaTemplate.send(topic, message);

    }
}
