package com.kepler;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname("localhost");
        config.setPort(8080); // Порт для WebSocket
        // config.setOrigin("*"); // Разрешение CORS

        config.setOrigin("http://localhost:8081"); // URL фронтенда

        return new SocketIOServer(config);
    }
}
