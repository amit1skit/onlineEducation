package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.UserReport;

@Repository
public interface UserReportRepo extends CrudRepository<UserReport, Long>{

}
