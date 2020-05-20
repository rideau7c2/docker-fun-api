package com.gitlab.rideau7c2.dockerfunapi.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmTokenRepository extends MongoRepository<ConfirmToken, String> {
    ConfirmToken findByToken(String token);
}
