package consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import producer.dto.CryptMessage;
import producer.dto.Message;

@Slf4j
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "messages.topic", groupId = "consumer-group-1")
    public void getKafkaCryptMessage(CryptMessage message){
        log.info(message.toString() + " ,getKafkaMessage method");
    }
}
