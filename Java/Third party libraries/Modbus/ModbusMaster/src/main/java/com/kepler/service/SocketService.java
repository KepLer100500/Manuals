package com.kepler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Service
@Slf4j
public class SocketService {
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

    public void run() {
        process();
    }

    private void process() {
        try (Socket socket = new Socket(host, port)) {
            readRegisters(socket);
            writeRegisters(socket);
        } catch (IOException | InterruptedException e) {
            log.error("Bad try to write registers");
        }
    }

    private void readRegisters(Socket socket) throws IOException, InterruptedException {
        OutputStream readOutputStream = socket.getOutputStream();
        readOutputStream.write(createReadRequest());
        readOutputStream.flush();

        InputStream readInputStream = socket.getInputStream();
        byte[] readResponse = new byte[9 + 2 * readCount];
        int readBytesRead = readInputStream.read(readResponse);

        if (readBytesRead > 0) {
            // log.error("Ответ от контроллера получен: {}", bytesToHex(response));
            int[] registerValues = parseRegisterValues(readResponse);
            for (int i = 0; i < registerValues.length; i++) {
                // log.error("Регистр {}: {}", registerAddress + i, registerValues[i]);
            }
        } else {
            log.error("Ответ от контроллера отсутствует или неверный.");
        }
        Thread.sleep(1);
    }

    private void writeRegisters(Socket socket) throws IOException, InterruptedException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(createWriteRequest());
        outputStream.flush();

        InputStream inputStream = socket.getInputStream();
        byte[] response = new byte[12];
        int bytesRead = inputStream.read(response);
        //log.error("{}", bytesToHex(response));
        Thread.sleep(1);
    }

    private int[] parseRegisterValues(byte[] response) {
        int byteCount = response[8] & 0xFF; // Количество байт данных (из Byte Count)
        int[] registerValues = new int[byteCount / 2];

        for (int i = 0; i < registerValues.length; i++) {
            // Каждый регистр состоит из 2 байт (старший + младший)
            int highByte = response[9 + i * 2] & 0xFF;
            int lowByte = response[10 + i * 2] & 0xFF;
            registerValues[i] = (highByte << 8) | lowByte;
        }

        return registerValues;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X ", b));
        }
        return hexString.toString().trim();
    }

    private byte[] createWriteRequest() {
        return new byte[]{
                0x00, 0x01, // Transaction ID (2 байта)
                0x00, 0x00, // Protocol ID (2 байта)
                0x00, 0x06, // Length (2 байта)
                (byte) slaveId,       // Unit ID (1 байт)
                0x06,       // Function Code (1 байт, 0x03 = чтение Holding Registers)
                // Starting Address (2 байта)
                (byte) (((registerAddress + writingOffset) >> 8) & 0xFF), // Старший байт
                (byte) ((registerAddress + writingOffset) & 0xFF),        // Младший байт
                // Quantity of Registers (2 байта)
                (byte) ((writingValue >> 8) & 0xFF), // Старший байт
                (byte) (writingValue & 0xFF)         // Младший байт
        };
    }

    private byte[] createReadRequest() {
        return new byte[]{
                0x00, 0x01, // Transaction ID (2 байта)
                0x00, 0x00, // Protocol ID (2 байта)
                0x00, 0x06, // Length (2 байта)
                (byte) slaveId,       // Unit ID (1 байт)
                0x03,       // Function Code (1 байт, 0x03 = чтение Holding Registers)
                // Starting Address (2 байта)
                (byte) (((registerAddress) >> 8) & 0xFF), // Старший байт
                (byte) ((registerAddress) & 0xFF),        // Младший байт
                // Quantity of Registers (2 байта)
                (byte) ((readCount >> 8) & 0xFF), // Старший байт
                (byte) (readCount & 0xFF)         // Младший байт
        };
    }
}
