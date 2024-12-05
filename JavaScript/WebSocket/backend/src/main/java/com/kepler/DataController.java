package com.kepler;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final SocketIOServer socketIOServer;

    @Autowired
    public DataController(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @PostMapping("/update")
    public String updateData(@RequestBody DataModel data) {
        socketIOServer.getBroadcastOperations().sendEvent("dataUpdated", data);
        return "Data updated!";
    }
}
