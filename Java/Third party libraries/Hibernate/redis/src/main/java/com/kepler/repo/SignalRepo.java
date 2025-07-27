package com.kepler.repo;

import com.kepler.model.Signal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepo extends CrudRepository<Signal, Integer> {

}
