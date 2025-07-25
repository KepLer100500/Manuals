package com.kepler.service;

import com.kepler.MessageTransferGrpc;
import com.kepler.SignalRequest;
import com.kepler.SignalResponse;
import com.kepler.model.Signal;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@GrpcService
@Slf4j
public class Grpc extends MessageTransferGrpc.MessageTransferImplBase {

    @Override
    public void sendSignal(SignalRequest request, StreamObserver<SignalResponse> responseObserver) {
        log.info("Server get request: {}", request);

        Signal signal = Signal.builder()
                .id(request.getId())
                .title("FI001")
                .timestamp(LocalDateTime.now())
                .value(500)
                .build();

        SignalResponse response = SignalResponse.newBuilder()
                .setId(signal.getId())
                .setTitle(signal.getTitle())
                .setTimestamp(signal.getTimestamp().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
                .setValue(signal.getValue())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
