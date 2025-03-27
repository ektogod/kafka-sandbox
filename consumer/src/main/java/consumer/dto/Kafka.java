package consumer.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka", ignoreUnknownFields = false)
public record Kafka(String bootstrapServers,
                    String groupId,
                    boolean enableAutoCommit,
                    int concurrency,
                    int maxPollRecords) {
}
