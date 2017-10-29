package com.in.power.education.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.power.education.model.Subscription;

@Repository
public interface SubscriptionRepo extends CrudRepository<Subscription, Long>{

}
