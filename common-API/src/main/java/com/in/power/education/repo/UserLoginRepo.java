package com.in.power.education.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.UserLogin;

@Repository
public interface UserLoginRepo extends PagingAndSortingRepository<UserLogin, Long>{

	UserLogin findByuserID(@Param("userID") String userID );
}
