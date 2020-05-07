package com.gitlab.rideau7c2.dockerfunapi.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "products", path = "products")
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
