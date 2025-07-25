package com.kepler.service;

import com.kepler.MessageTransferGrpc;
import com.kepler.SignalRequest;
import com.kepler.SignalResponse;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Grpc {
    @GrpcClient("gRPCSignalClient")
    private MessageTransferGrpc.MessageTransferBlockingStub serviceStub;

    public SignalResponse getSignal(int id) {
        SignalRequest request = SignalRequest.newBuilder()
                .setId(id)
                .build();
        return serviceStub.sendSignal(request);
    }
}
