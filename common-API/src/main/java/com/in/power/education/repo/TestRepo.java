package com.in.power.education.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Test;

@Repository
public interface TestRepo extends CrudRepository<Test, Long>{

	List<Test> findByTestName(@Param("testName") String testName);
	
	List<Test> findByCategory(@Param("category") String category);
			
}
