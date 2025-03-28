package producer.websocket;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.springframework.stereotype.Component;
import producer.config.WebSocketConfig;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebSocketClient {
    KafkaWebSocketListener listener;
    WebSocketConfig webSocketConfig;

    public void activateClient(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(webSocketConfig.getSubscribeLink())
                .build();

        WebSocket ws = client.newWebSocket(request, listener);
        client.dispatcher().executorService().shutdown();
    }

}
