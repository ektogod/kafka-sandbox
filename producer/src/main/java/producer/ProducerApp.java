package producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import producer.websocket.WebSocketClient;

import java.util.Collections;

@SpringBootApplication
public class ProducerApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProducerApp.class);
        app.setDefaultProperties(Collections.singletonMap(
                "spring.config.name", "producer"
        ));

        var context = app.run(args);

        WebSocketClient client = context.getBean(WebSocketClient.class);
        client.activateClient();
    }
}
