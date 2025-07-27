package com.kepler.service;

import com.kepler.config.ShardRoutingDataSource;
import com.kepler.config.ShardUtil;
import com.kepler.model.User;
import com.kepler.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        int shardId = ShardUtil.getShardId(user.getId() != null ? user.getId() : new Random().nextLong());
        ShardRoutingDataSource.setCurrentShard(shardId);
        try {
            return userRepository.save(user);
        } finally {
            ShardRoutingDataSource.clear();
        }
    }

    public Optional<User> findById(Long userId) {
        int shardId = ShardUtil.getShardId(userId);
        ShardRoutingDataSource.setCurrentShard(shardId);
        try {
            return userRepository.findById(userId);
        } finally {
            ShardRoutingDataSource.clear();
        }
    }
}
