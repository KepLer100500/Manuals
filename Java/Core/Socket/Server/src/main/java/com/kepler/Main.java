package com.kepler;

import com.kepler.model.Message;
import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.UUID;


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

    private static Message getMessage(BufferedReader reader) throws IOException {
        String request = reader.readLine();
        log.info("Server get request: {}", request);
        return Message.builder()
                .uuid(UUID.randomUUID())
                .text(request)
                .dateTime(LocalTime.now())
                .build();
    }

    private static void sendMessage(BufferedWriter writer, Message message) throws IOException {
        writer.write(message.toString());
        writer.newLine();
        writer.flush();
        log.info("Server send response: {}", message.toString());
    }

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)){
            log.info("Server started on 8000 port");

            while(true) {
                new Thread(() -> {
                    try (Socket socket = server.accept();
                        BufferedReader reader = getReader(socket);
                        BufferedWriter writer = getWriter(socket)) {

                            Message message = getMessage(reader);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            sendMessage(writer, message);

                    } catch (IOException | NullPointerException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
