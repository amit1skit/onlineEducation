package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.CourseInfo;

@Repository
public interface CourseInfoRepo extends CrudRepository<CourseInfo, Long>{

}
