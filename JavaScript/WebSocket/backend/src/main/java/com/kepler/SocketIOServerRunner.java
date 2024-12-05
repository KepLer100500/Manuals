package com.kepler;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SocketIOServerRunner implements CommandLineRunner {

    private final SocketIOServer socketIOServer;

    @Autowired
    public SocketIOServerRunner(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @Override
    public void run(String... args) {
        socketIOServer.addEventListener("updateData", DataModel.class, (client, data, ackSender) -> {
            // Шлём данные всем клиентам
            socketIOServer.getBroadcastOperations().sendEvent("dataUpdated", data);
        });

        socketIOServer.start();
    }
}
