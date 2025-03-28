package database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "database.repository")
public class DatabaseApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DatabaseApp.class);
        app.setDefaultProperties(Collections.singletonMap(
                "spring.config.name", "database"
        ));

        app.run(args);
    }
}
