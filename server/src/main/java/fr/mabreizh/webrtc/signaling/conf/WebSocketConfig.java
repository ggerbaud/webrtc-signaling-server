package fr.mabreizh.webrtc.signaling.conf;

import fr.mabreizh.webrtc.signaling.socket.SignalingSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Guillaume Gerbaud
 */
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry
                // handle on "/signal" endpoint
                .addHandler(signalingSocketHandler(), "/signal")
                // Allow cross origins
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler signalingSocketHandler() {
        return new SignalingSocketHandler();
    }
}
