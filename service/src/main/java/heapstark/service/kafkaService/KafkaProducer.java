package heapstark.service.kafkaService;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/21.
 */
public interface KafkaProducer {
   void sendDefaultTopic(String message);
}
