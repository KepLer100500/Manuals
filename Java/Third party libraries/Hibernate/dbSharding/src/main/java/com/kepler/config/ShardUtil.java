package com.kepler.config;

public class ShardUtil {
    public static int getShardId(long userId) {
        return (int) (userId % 3);
    }
}