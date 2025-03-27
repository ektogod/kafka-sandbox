    package producer.dto;

    import org.springframework.boot.context.properties.ConfigurationProperties;

    import java.time.Duration;

    @ConfigurationProperties(prefix = "app.kafka", ignoreUnknownFields = false)
    public record Kafka(String bootstrapServers,
                        String clientId,
                        Duration deliveryTimeout,
                        int lingerMs,
                        int batchSize) {
    }
