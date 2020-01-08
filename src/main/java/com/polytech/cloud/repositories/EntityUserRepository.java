package com.polytech.cloud.repositories;

import com.polytech.cloud.model.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EntityUserRepository extends JpaRepository<EntityUser, Integer> {

    @Override
    public void deleteAll();
}
