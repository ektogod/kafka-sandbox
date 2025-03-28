package producer.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.springframework.stereotype.Component;
import producer.dto.CryptMessage;
import producer.producer.KafkaProducer;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaWebSocketListener extends WebSocketListener {
    private final KafkaProducer producer;
    private final int NORMAL_CLOSURE_STATUS = 1000;
    private boolean isFirstMsgReceived = false;

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        log.info("WebSocket session established");
        webSocket.send("{\n" +
                "    \"type\": \"subscribe\",\n" +
                "    \"product_ids\": [\n" +
//                "        \"ETH-USD\",\n" +
                "        \"BTC-USD\"\n" +
                "    ],\n" +
                "    \"channels\": [\"ticker\"]\n" +
                "}");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        ObjectMapper mapper = new ObjectMapper();
        CryptMessage message;
        if(isFirstMsgReceived) {
            try {
                message = mapper.readValue(text, CryptMessage.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            producer.sendMessage(message);
        }
        else {
            isFirstMsgReceived = true;
        }
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        System.out.println("Receiving: " + bytes.hex());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
        System.out.println("Closing: " + code + " " + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        t.printStackTrace();
    }
}
