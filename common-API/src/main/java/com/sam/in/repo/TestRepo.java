package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sam.in.model.Test;

@Repository
public interface TestRepo extends CrudRepository<Test, Long>{

}
