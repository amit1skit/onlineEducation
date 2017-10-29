package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{

}
