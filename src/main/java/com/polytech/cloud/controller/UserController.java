package com.polytech.cloud.controller;

import com.polytech.cloud.model.EntityUser;
import com.polytech.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService serviceUser;

    @Autowired
    public UserController(UserService serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping
    @ResponseBody
    public List<EntityUser> getAllUsers() {
        return serviceUser.findAll();
    }

    @DeleteMapping
    @ResponseBody
    public void deleteAllUsers() {
        serviceUser.deleteAll();
    }

    @PutMapping
    @ResponseBody
    public List<EntityUser> replaceAllUsers(@Valid @RequestBody List<EntityUser> users) {
        return serviceUser.replaceAll(users);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public EntityUser getUserById(@PathVariable("id") String id) {
        return serviceUser.findById(id);
    }

    // FONCTION EN TROP, SIMPLEMENT POUR TESTER LES AJOUTS / UPDATES POTENTIELS
    @GetMapping(value = "/name/{name}")
    @ResponseBody
    public List<EntityUser> getUserByLastName(@PathVariable("name") String name) {
        return serviceUser.findByLastName(name);
    }

    @PostMapping
    @ResponseBody
    public EntityUser insertUser(@Valid @RequestBody EntityUser user) {
        // On supprime l'ID potentiellement tapé par l'utilisateur (il sera auto-généré par MongoDB lors de l'ajout).
        user.setId(null);
        return serviceUser.add(user);
    }

    @PutMapping(value = "/{id}")
    public EntityUser updateUser(@PathVariable("id") String id,
                                 @Valid @RequestBody EntityUser newUser) {
        // Tous les champs de l'entité dans la requête remplaceront les anciennes valeurs de l'entité en base.
        EntityUser oldUser = serviceUser.findById(id);
        return serviceUser.update(oldUser, newUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") String id) {
        serviceUser.delete(id);
    }

}
