package producer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@PropertySource("classpath:producer.yml")
@Getter
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Value("${app.websocket.subscribe_link}")
    private String subscribeLink;
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws")      //по типу http://localhost:8080/ws
//                .setAllowedOrigins("*");
//    }
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/kafka");
//        registry.enableSimpleBroker("/kafka");
//        registry.setUserDestinationPrefix("/user");
//    }
}
