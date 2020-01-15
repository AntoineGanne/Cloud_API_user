package com.polytech.cloud.service;

import com.polytech.cloud.exception.NegativePageException;
import com.polytech.cloud.exception.UserException;
import com.polytech.cloud.exception.UserNotFoundException;
import com.polytech.cloud.model.EntityUser;
import com.polytech.cloud.repositories.RepositoryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final RepositoryUser repositoryUser;

    @Autowired
    public UserService(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public EntityUser findById(String id) throws UserNotFoundException {
        return repositoryUser.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Aucun utilisateur avec ID = '%s", id)));
    }

    public List<EntityUser> findByLastName(String lastName) throws UserNotFoundException {
        return repositoryUser.findByLastName(lastName);
    }

    public Page<EntityUser> findAll(int page) throws NegativePageException {
        // nombre d'éléments par page
        int PAGE_SIZE = 100;

        if (page < 0) {
            throw new NegativePageException("L'index de la page doit être >= 0");
        }

        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        return repositoryUser.findAll(pageable);
    }


    public EntityUser add(EntityUser user) {
        // L'ID est automatiquement généré lors de l'ajout.
        return repositoryUser.save(user);
    }

    public List<EntityUser> addAll(List<EntityUser> users) {
        return repositoryUser.saveAll(users);
    }

    public EntityUser update(EntityUser oldUser) {
        return repositoryUser.save(oldUser);
    }

    public void delete(String id) throws UserException {
        repositoryUser.deleteById(id);
    }

    public void deleteAll() {
        repositoryUser.deleteAll();
    }

    public List<EntityUser> replaceAll(List<EntityUser> users) {
        deleteAll();
        return addAll(users);
    }
}
