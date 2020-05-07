package com.gitlab.rideau7c2.dockerfunapi.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "products", path = "products")
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
