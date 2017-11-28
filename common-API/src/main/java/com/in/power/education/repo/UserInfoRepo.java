package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.UserInfo;
import com.in.power.education.model.UserLogin;

@Repository
public interface UserInfoRepo extends CrudRepository<UserInfo, Long>{

	UserInfo findByuserLogin(@Param("userLogin") UserLogin  userLogin);
	
	UserInfo findByuserID(@Param("userID") String  userID);
}
