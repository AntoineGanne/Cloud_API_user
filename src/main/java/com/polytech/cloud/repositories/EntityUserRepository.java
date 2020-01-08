package com.polytech.cloud.repositories;

import com.polytech.cloud.model.EntityUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EntityUserRepository extends JpaRepository<EntityUsers, Integer> {

    @Override
    public void deleteAll();
}
