package database.consumer;

import database.mapstruct.MessageMapper;
import database.repository.MessageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import producer.dto.CryptMessage;

@Slf4j
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class KafkaConsumer {
    MessageMapper mapper;
    MessageRepository repository;

    @KafkaListener(topics = "messages.topic", groupId = "consumer-group-db")
    public void getKafkaCryptMessage(CryptMessage message){
        repository.save(mapper.dtoToEntity(message)); //можно в сервис убрать
    }
}
