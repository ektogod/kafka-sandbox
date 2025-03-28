package producer;

import database.DatabaseApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import producer.websocket.WebSocketClient;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
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
