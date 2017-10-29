package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sam.in.model.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{

}
