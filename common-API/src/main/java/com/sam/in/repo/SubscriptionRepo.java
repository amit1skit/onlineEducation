package com.sam.in.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sam.in.model.Subscription;

@Repository
public interface SubscriptionRepo extends CrudRepository<Subscription, Long>{

}
