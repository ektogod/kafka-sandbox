package consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import producer.dto.CryptMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    @KafkaListener(topicPartitions = @TopicPartition(topic = "messages.topic", partitions = {"0"}),
            groupId = "consumer-group-1",
            containerFactory = "kafkaListenerContainerFactory")

    public void getKafkaCryptMessage(CryptMessage message) {
        log.info(message.toString() + ", partition 0");
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "messages.topic", partitions = {"1"}),
            groupId = "consumer-group-1",
            containerFactory = "kafkaListenerContainerFactory")

    public void getKafkaCryptMessage2(CryptMessage message) {
        log.info(message.toString() + ", partition 1");
    }
}
