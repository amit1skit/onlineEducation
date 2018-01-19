package com.in.power.education.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Subject;
import com.in.power.education.model.Topic;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Long>{

	Topic findBytNm(@Param("tNm") String tNm);
	List<Topic> findBySubject(@Param("subject") Subject subject );
}
