package com.in.power.education.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Question;
import com.in.power.education.model.Subject;
import com.in.power.education.model.Topic;


@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{

	List<Question> findBySubject(@Param("subject") Subject subject );
	
	List<Question> findBySubjectAndTopic(@Param("subject") Subject subject,
										 @Param("topic") Topic topic);
	
	List<Question> findBySubjectAndTagId(@Param("subject") Subject subject,
			 							 @Param("tagId") String tagId);
	
	List<Question> findBySubjectAndTopicAndTagId(@Param("subject") Subject subject,
			 									 @Param("topic") Topic topic,
			 									@Param("tagId") String tagId);

	List<Question> findBySubjectAndTopicAndTagIdAndOptionType(@Param("subject") Subject subject,
			 @Param("topic") Topic topic,
			@Param("tagId") String tagId,
			@Param("optionType") String optionType);

	List<Question> findBySubjectAndTopicAndOptionType(@Param("subject") Subject subject,
			 @Param("topic") Topic topic,
			@Param("optionType") String optionType);

	List<Question> findByTagId(@Param("tagId") String tagId );
}


