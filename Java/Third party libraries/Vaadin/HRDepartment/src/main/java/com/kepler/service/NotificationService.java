package com.kepler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class NotificationService {
    private final List<Consumer<Void>> listeners = new ArrayList<>();

    public void registerListener(Consumer<Void> listener) {
        listeners.add(listener);
    }

    public void notifyAllClients() {
        listeners.forEach(listener -> listener.accept(null));
    }
}
