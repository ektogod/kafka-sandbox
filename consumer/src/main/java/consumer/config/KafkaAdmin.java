package consumer.config;

import consumer.dto.Kafka;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.admin.NewPartitions;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Component(value = "myKafkaAdmin")
@RequiredArgsConstructor
public class KafkaAdmin {
    private final Kafka kafka;

    public void setPartitions(String topic, int amount) {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafka.bootstrapServers());

        try (AdminClient client = AdminClient.create(props)) {
            client.createPartitions(Map.of(topic, NewPartitions.increaseTo(amount)))
                    .all()
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
