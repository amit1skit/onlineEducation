package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sam.in.model.StudentReport;

@Repository
public interface StudentReportRepo extends CrudRepository<StudentReport, Long>{

}
