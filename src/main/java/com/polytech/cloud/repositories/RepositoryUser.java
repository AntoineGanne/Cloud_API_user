package com.polytech.cloud.repositories;

import com.polytech.cloud.model.EntityUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends MongoRepository<EntityUser, Integer> {

}
