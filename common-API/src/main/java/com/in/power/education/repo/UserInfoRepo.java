package com.in.power.education.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.UserInfo;
import com.in.power.education.model.UserLogin;

@Repository
public interface UserInfoRepo extends CrudRepository<UserInfo, Long>{

	UserInfo findByuserLogin(@Param("userLogin") UserLogin  userLogin);
	
	UserInfo findByuserID(@Param("userID") String  userID);
	
	@Query("select u from UserInfo u where status='A' AND "
			+ "(u.fName like %?1% OR u.lName like %?1% OR u.userID like %?1%)")
	List<UserInfo> findByfNameLike(@Param("fName") String  fName);
	
	@Query("select u from UserInfo u where status='I' AND "
			+ "(u.fName like %?1% OR u.lName like %?1% OR u.userID like %?1%)")
	List<UserInfo> findBylNameLike(@Param("lName") String  lName);
	
	@Query("select u from UserInfo u where "
			+ "u.fName like %?1% OR u.lName like %?1% OR u.userID like %?1%")
	List<UserInfo> findByuserIDLike(@Param("userID") String  userID);
	
	UserInfo findBylName(@Param("lName") String  lName);
}
