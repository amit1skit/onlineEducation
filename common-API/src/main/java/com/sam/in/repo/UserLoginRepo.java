package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sam.in.model.UserLogin;

@Repository
public interface UserLoginRepo extends CrudRepository<UserLogin, Long>{

	UserLogin findByuserID(@Param("userID") String userID );
}
