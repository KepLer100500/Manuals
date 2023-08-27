package com.kepler.service;

import com.kepler.model.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;


@Service
public class HighLoadService {

    /**
     * Get record from abstract service with 5 sec delay
     * @param recordId int
     * @param name String
     * @return Employee
     */
    @Cacheable(cacheNames = {"employeeCache"}, key = "{#recordId}")
    public Employee createOrGetEmployee(int recordId, String name) {
        try {
            TimeUnit.SECONDS.sleep(5);
            return new Employee(recordId, LocalTime.now(), name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update employee record in cache
     * @param recordId int
     * @param name String
     * @return Employee
     */
    @CachePut(cacheNames = {"employeeCache"}, key = "{#recordId}")
    public Employee updateEmployee(int recordId, String name) {
        return new Employee(recordId, LocalTime.now(), name);
    }

    /**
     * Remove from cache employee record
     * @param recordId int
     */
    @CacheEvict(cacheNames = {"employeeCache"}, key = "{#recordId}")
    public void removeEmployee(int recordId) {
        // remove form DB logic
    }
}
