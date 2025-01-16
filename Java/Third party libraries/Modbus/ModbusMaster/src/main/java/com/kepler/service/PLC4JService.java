package com.kepler.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.messages.PlcWriteRequest;
import org.apache.plc4x.java.api.types.PlcResponseCode;
import org.apache.plc4x.java.api.value.PlcValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class PLC4JService {
    @Value("${modbus.host}")
    private String host;
    @Value("${modbus.port}")
    private int port;
    @Value("${modbus.slaveId}")
    private int slaveId;
    @Value("${modbus.registerAddress}")
    private int registerAddress;
    @Value("${modbus.readCount}")
    private int readCount;
    @Value("${modbus.writingOffset}")
    private int writingOffset;
    @Value("${modbus.writingValue}")
    private int writingValue;

    private PlcConnection connection;

    public void run() {
        connect();
        writeRegisters();
        readRegisters();
        disconnect();
    }

    private void connect() {
        PlcDriverManager manager = new PlcDriverManager();

        try {
            connection = manager.getConnection("modbus-tcp:tcp://" + host + ":" + port + "?unit-identifier=" + slaveId);
        } catch (PlcConnectionException e) {
            log.error("connect failed: PLC is not connected");
        }
    }

    private void disconnect() {
        if (connection != null && connection.isConnected()) {
            try {
                connection.close();
            } catch (Exception e) {
                log.error("Bad try to disconnect");
            }
        } else {
            log.error("disconnect failed: PLC is not connected");
        }
    }

    public void writeRegisters() {
        if (connection != null && connection.isConnected()) {
            PlcWriteRequest.Builder writer = connection.writeRequestBuilder();
            writer.addItem("command", "holding-register:" + (registerAddress + writingOffset + 1) + "[1]", writingValue);
            PlcWriteRequest writeRequest = writer.build();
            try {
                writeRequest.execute().get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Bad try to write registers");
            }
        } else {
            log.error("writing is failed: PLC is not connected");
        }
    }

    private void readRegisters() {
        if (connection != null && connection.isConnected()) {
            try {
                PlcReadRequest.Builder builder = connection.readRequestBuilder();
                builder.addItem("registers", "holding-register:" + (registerAddress + 1) + "[" + readCount + "]").build();
                PlcReadRequest readRequest = builder.build();
                PlcReadResponse response = readRequest.execute().get();
                if (response.getResponseCode("registers") == PlcResponseCode.OK) {
                    PlcValue plcValue = response.getPlcValue("registers");
                    Integer[] registerValues = plcValue.getList().stream().map(PlcValue::getInteger).toArray(Integer[]::new);
                    for (Integer value : registerValues) {
                        // log.error("Address: {}, Value: {}", registerAddress++, value);
                    }
                } else {
                    log.error("Bad response in reading registers");
                }
            } catch (ExecutionException | InterruptedException e) {
                log.error("Bad try to read holding registers");
            }
        } else {
            log.error("reading failed: PLC is not connected");
        }

    }

}
