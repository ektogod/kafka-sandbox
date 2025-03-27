package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsumerApp.class);
        app.setDefaultProperties(Collections.singletonMap(
                "spring.config.name", "consumer"
        ));

        app.run(args);
    }
}
