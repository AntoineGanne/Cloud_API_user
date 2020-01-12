package com.polytech.cloud.controller;

import com.polytech.cloud.model.EntityUser;
import com.polytech.cloud.repositories.RepositoryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private RepositoryUser repositoryUser;

    @Autowired
    public UserController(RepositoryUser utilisateurRepository) {
        this.repositoryUser = utilisateurRepository;
    }

    @GetMapping
    public ResponseEntity<List<EntityUser>> getAllUsers() {
        return ResponseEntity.ok(repositoryUser.findAll());
    }

    @PostMapping
    @ResponseBody
    public void replaceAllUsers(@Valid @RequestBody List<EntityUser> users) {
        repositoryUser.deleteAll();
        repositoryUser.saveAll(users);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        repositoryUser.deleteAll();
    }



}
