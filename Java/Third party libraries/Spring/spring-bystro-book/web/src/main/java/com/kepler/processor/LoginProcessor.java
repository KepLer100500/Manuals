package com.kepler.processor;

import com.kepler.service.LoggedUserManagmentService;
import com.kepler.service.LoginCountService;
import org.springframework.stereotype.Component;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Data
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;
    
    @Autowired
    private LoggedUserManagmentService loggedUserManagmentService;
    
    @Autowired
    private LoginCountService loginCountService;
    
    public boolean loggedIn() {
        loginCountService.increment();
        
        String user = this.getUsername();
        String pass = this.getPassword();
        
        boolean loginStatus = false;
        if("root".equals(user) && "root".equals(pass)) {
            loginStatus = true;
            loggedUserManagmentService.setUsername(user);
            
        }
        return loginStatus;
    }
}
