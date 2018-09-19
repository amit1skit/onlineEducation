package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.UserSubscription;

@Repository
public interface UserSubscriptionRepo extends CrudRepository<UserSubscription, Long>{

}
