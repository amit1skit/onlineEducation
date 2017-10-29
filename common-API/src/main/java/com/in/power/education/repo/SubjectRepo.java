package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Subject;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Long>{

}
