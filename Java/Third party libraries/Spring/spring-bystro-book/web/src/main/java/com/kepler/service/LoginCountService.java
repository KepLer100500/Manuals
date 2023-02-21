package com.kepler.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@Data
@ApplicationScope
public class LoginCountService {
    private int count;
    
    public void increment(){
        count++;
    }
}
