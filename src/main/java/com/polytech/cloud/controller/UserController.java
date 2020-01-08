package com.polytech.cloud.controller;

import com.polytech.cloud.model.EntityUser;
import com.polytech.cloud.repositories.EntityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private EntityUserRepository unUtilisateurRepository;

    // On initialise
    @Autowired
    public UserController(EntityUserRepository utilisateurRepository) {
        this.unUtilisateurRepository = utilisateurRepository;
    }

    @GetMapping("/user")
    public List<EntityUser> getUsers() {
        return unUtilisateurRepository.findAll();
    }


    @DeleteMapping(value= "/user")
    public void deleteUserByUsername() {
        unUtilisateurRepository.deleteAll();
    }

    @PostMapping(value= "/user")
    @ResponseBody
    public void insertUser(@RequestBody EntityUser entityUser) {
        unUtilisateurRepository.save(entityUser);
    }

}
