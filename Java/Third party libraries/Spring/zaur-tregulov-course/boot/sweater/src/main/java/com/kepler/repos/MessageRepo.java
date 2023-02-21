package com.kepler.repos;

import com.kepler.entities.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {

        List<Message> findByText(String text);

}
