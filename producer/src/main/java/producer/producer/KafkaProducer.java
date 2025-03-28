package producer.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import producer.dto.CryptMessage;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class KafkaProducer {
    final KafkaTemplate<String, CryptMessage> template;
    boolean isForZeroPartition = true;

    public void sendMessage(CryptMessage message){
        if(isForZeroPartition) {
            template.send("messages.topic", 0, "consumer-group-1", message);
            isForZeroPartition = false;
        }
        else {
            template.send("messages.topic", 1, "consumer-group-1", message);
            isForZeroPartition = true;
        }
        //сверху костыль - по-другому сообщения шли только в одну партицию
        template.send("messages.topic", "consumer-group-db", message);
    }
}
