package com.kepler.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@Data
@SessionScope
public class LoggedUserManagmentService {
    private String username;
}
