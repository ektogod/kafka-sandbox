package consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;
import producer.dto.Message;

@Slf4j
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "messages.topic", groupId = "consumer-group-1")
    public void getKafkaMessage(Message message){
        log.info(message.toString() + " ,getKafkaMessage method");
    }

//    @RetryableTopic(attempts = "5")
//    @KafkaListener(topics = "messages.topic", groupId = "consumer-group-1")
//    public void getKafkaMessage2(Message message){
//        log.info(message.toString(), " ,getKafkaMessage2 method");
//    }
}
