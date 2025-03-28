package producer.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import producer.producer.KafkaProducer;

@Controller
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class KafkaController {
    KafkaProducer producer;
    @MessageMapping("/kafka")
    public void processMessage(@Payload String message){

    }

}
