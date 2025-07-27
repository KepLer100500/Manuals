package com.kepler.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ShardRoutingDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<Integer> currentShard = new ThreadLocal<>();

    public static void setCurrentShard(Integer shardId) {
        currentShard.set(shardId);
    }

    public static void clear() {
        currentShard.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return currentShard.get();
    }
}
