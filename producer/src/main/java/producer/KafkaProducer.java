package producer;

import producer.dto.Message;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class KafkaProducer {
    KafkaTemplate<String, Message> template;

    public void sendMessage(Message message){
        template.send("messages.topic", message);
    }
}
