package com.kepler.service;

import com.kepler.model.Signal;
import com.kepler.repo.SignalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalService {
    @Autowired
    private SignalRepo signalRepo;

    public void createSignal(Signal signal) {
        signalRepo.save(signal);
    }

    public Signal getSignal(Integer id) {
        return signalRepo.findById(id).orElse(null);
    }

    public List<Signal> getAllSignals() {
        return (List<Signal>) signalRepo.findAll();
    }

    public void removeSignal(Integer id) {
        signalRepo.deleteById(id);
    }
}
