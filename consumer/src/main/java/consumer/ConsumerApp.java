package consumer;

import consumer.config.KafkaAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsumerApp.class);
        app.setDefaultProperties(Collections.singletonMap(
                "spring.config.name", "consumer"
        ));

        var context = app.run(args);
        KafkaAdmin admin = context.getBean(KafkaAdmin.class);
        admin.setPartitions("messages.topic", 2);
    }
}
