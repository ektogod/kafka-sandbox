package producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import producer.dto.Message;

import java.util.Collections;

@SpringBootApplication
public class ProducerApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProducerApp.class);
        app.setDefaultProperties(Collections.singletonMap(
                "spring.config.name", "producer"
        ));

        var context = app.run(args);
        KafkaProducer app1 = context.getBean(KafkaProducer.class);
        app1.sendMessage(new Message("msg", "msg from Lera", "Lera", 20));
    }
}
