package heapstark.controller;

import heapstark.service.kafkaService.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/21.
 */
@RestController
public class KafkaController {
    @Autowired
    KafkaProducer kafkaProducer;

    @RequestMapping("/kafka/{hello}")
    public String hello(@PathVariable String hello) {
        kafkaProducer.sendDefaultTopic(hello);
        return "hello";
    }
}
