package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sam.in.model.Subject;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Long>{

}
