package com.kepler;

import com.kepler.service.JLibModbusService;
import com.kepler.service.PLC4JService;
import com.kepler.service.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;


/**
 * Tests read local modbus server 10 registers: from 41000 to 41010 and write to 41008 register value: 777
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Comparison modbus libraries.")
@Slf4j
@SpringBootTest
public class ModbusTest {
    @Autowired
    private JLibModbusService jLibModbusService;
    @Autowired
    private PLC4JService plc4JService;
    @Autowired
    private SocketService socketService;

    @RepeatedTest(10)
    @Order(10)
    @DisplayName("JLibModbus library.")
    public void JLibModbusServiceTest() {
        jLibModbusService.run();
    }

    @RepeatedTest(10)
    @Order(20)
    @DisplayName("Socket library.")
    public void SocketServiceTest() {
        socketService.run();
    }

    @RepeatedTest(10)
    @Order(30)
    @DisplayName("PLC4J library.")
    public void PLC4JServiceTest() {
        plc4JService.run();
    }
}
