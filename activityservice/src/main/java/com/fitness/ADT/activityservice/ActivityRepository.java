package com.fitness.ADT.activityservice;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitness.ADT.activityservice.model.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    List<Activity> findByUserId(String userId);
}
