package com.polytech.cloud.repositories;

import com.polytech.cloud.model.EntityUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryUser extends MongoRepository<EntityUser, Integer> {

    void deleteById(String id);

    List<EntityUser> findByLastName(String lastName);

    Optional<EntityUser> findById(String id);
}
