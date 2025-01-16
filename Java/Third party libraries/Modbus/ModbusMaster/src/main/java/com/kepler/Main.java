package com.kepler;

import com.kepler.service.JLibModbusService;
import com.kepler.service.PLC4JService;
import com.kepler.service.SocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        var context = SpringApplication.run(Main.class, args);
        SpringApplication.run(Main.class, args);

//        JLibModbusService jLibModbusService = context.getBean(JLibModbusService.class);
//        for (int i = 0; i < 10; i++) {
//            jLibModbusService.run();
//        }
//
//        PLC4JService plc4JService = context.getBean(PLC4JService.class);
//        for (int i = 0; i < 10; i++) {
//            plc4JService.run();
//        }
//
//        SocketService socketService = context.getBean(SocketService.class);
//        for (int i = 0; i < 10; i++) {
//            socketService.run();
//        }

    }
}
