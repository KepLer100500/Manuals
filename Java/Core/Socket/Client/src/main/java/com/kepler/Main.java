package com.kepler;

import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.net.Socket;


@Slf4j
public class Main {
    private static BufferedReader getReader(Socket socket) throws IOException {
        return new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                )
        );
    }

    private static BufferedWriter getWriter(Socket socket) throws IOException {
        return new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()
                )
        );
    }

    private static void sendMessage(BufferedWriter writer, String text) throws IOException {
        log.info("Client send request: {}", text);
        writer.write(text);
        writer.newLine();
        writer.flush();
    }

    private static void getMessage(BufferedReader reader) throws IOException {
        String response = reader.readLine();
        log.info("Client get response: {}", response);
    }

    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8000);
            BufferedReader reader = getReader(socket);
            BufferedWriter writer = getWriter(socket)) {

            sendMessage(writer, "Test message");
            getMessage(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}