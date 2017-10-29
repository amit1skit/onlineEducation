package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sam.in.model.Topic;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Long>{

}
