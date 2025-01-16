package com.kepler.service;

import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@Slf4j
public class JLibModbusService {
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

    private ModbusMaster master;

    public void run() {
        connect();
        readRegisters();
        writeRegisters();
        disconnect();
    }

    private void connect() {
        TcpParameters tcpParameters = new TcpParameters();
        try {
            tcpParameters.setHost(InetAddress.getByName(host));
            tcpParameters.setPort(port);
            tcpParameters.setKeepAlive(true);

            master = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);

            if (!master.isConnected()) {
                master.connect();
            }

        } catch (UnknownHostException | ModbusIOException e) {
            log.error("connect failed: PLC is not connected");
        }
    }

    private void disconnect() {
        if (master != null && master.isConnected()) {
            try {
                master.disconnect();
            } catch (ModbusIOException e) {
                log.error("Bad try to disconnect");
            }
        } else {
            log.error("disconnect failed: PLC is not connected");
        }
    }

    private void readRegisters() {
        if (master != null && master.isConnected()) {
            try {
                int[] registerValues = master.readHoldingRegisters(slaveId, registerAddress, readCount);
                for (int value : registerValues) {
                    // log.error("Address: {}, Value: {}", registerAddress++, value);
                }
            } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
                log.error("Bad try to read holding registers");
            }
        } else {
            log.error("reading failed: PLC is not connected");
        }
    }

    private void writeRegisters() {
        if (master != null && master.isConnected()) {
            try {
                master.writeSingleRegister(slaveId, registerAddress + writingOffset, writingValue);
            } catch (ModbusProtocolException | ModbusNumberException | ModbusIOException e) {
                log.error("Bad try to write registers");
            }
        } else {
            log.error("writing is failed: PLC is not connected");
        }
    }

}
