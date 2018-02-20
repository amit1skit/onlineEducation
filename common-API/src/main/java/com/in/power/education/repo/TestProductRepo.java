package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.TestProduct;

@Repository
public interface TestProductRepo extends CrudRepository<TestProduct, Long>{

}
