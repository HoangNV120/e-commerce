package com.ecommerce.profileservice.repository;

import com.ecommerce.profileservice.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}