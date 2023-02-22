package com.kepler.service;

import com.kepler.model.User;
import com.kepler.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Transactional
    public void addDefaultUsersToDB() {
        userRepo.saveAll(User.createDefaultUsers());
    }
}
