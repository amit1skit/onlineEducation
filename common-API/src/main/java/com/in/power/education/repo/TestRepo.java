package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Test;

@Repository
public interface TestRepo extends CrudRepository<Test, Long>{

}
