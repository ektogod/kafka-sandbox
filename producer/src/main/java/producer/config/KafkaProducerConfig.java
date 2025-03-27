package producer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.serializer.JsonSerializer;
import producer.dto.Kafka;
import producer.dto.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(Kafka.class)
//@PropertySource("classpath:producer.yml")
/*@ConfigurationProperties(prefix = "app.kafka", ignoreUnknownFields = false)*/
public class KafkaProducerConfig {
    private final Kafka kafka;

    @Bean
    ProducerFactory<String, Message> producerFactory() {
        return new DefaultKafkaProducerFactory<>(
                Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.bootstrapServers(),
                        ProducerConfig.CLIENT_ID_CONFIG, kafka.clientId(),
                        ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, (int)kafka.deliveryTimeout().toMillis(),
                        ProducerConfig.LINGER_MS_CONFIG, kafka.lingerMs(),
                        ProducerConfig.BATCH_SIZE_CONFIG, kafka.batchSize(),
                        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class));
    }

    @Bean
    KafkaTemplate<String, Message> kafkaTemplate(ProducerFactory<String, Message> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
