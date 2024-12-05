package com.kepler;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UpdateService {
    private final SocketIOServer socketIOServer;
    private int value = 0;
    private int sign = 1;

    public UpdateService(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @Scheduled(fixedRate = 100) // Каждые 0.1 секунд
    public void sendUpdates() {
        DataModel data = new DataModel();
        data.setField1(String.valueOf(new Random().nextInt(100)));
        data.setField2(String.valueOf(new Random().nextInt(100)));
        if(value >= 100) {
            sign = -1;
        }
        if(value <= 0) {
            sign = 1;
        }
        value += sign;

        data.setField3(String.valueOf(value));

        socketIOServer.getBroadcastOperations().sendEvent("dataUpdated", data);
    }
}