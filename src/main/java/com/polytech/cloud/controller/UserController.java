package com.polytech.cloud.controller;

import com.polytech.cloud.exception.UserException;
import com.polytech.cloud.exception.UserValidationException;
import com.polytech.cloud.exception.UserNotFoundException;
import com.polytech.cloud.model.EntityUser;
import com.polytech.cloud.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
    public List<EntityUser> getAllUsers(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return serviceUser.findAll(page).getContent();
    }

    @DeleteMapping
    public void deleteAllUsers() {
        serviceUser.deleteAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<EntityUser> replaceAllUsers(@Valid @RequestBody List<EntityUser> users) {
        return serviceUser.replaceAll(users);
    }

    @GetMapping(value = "/{id}")
    public EntityUser getUserById(@PathVariable("id") String id) throws UserNotFoundException {
        return serviceUser.findById(id);
    }

    // FONCTION EN TROP, SIMPLEMENT POUR TESTER LES AJOUTS / UPDATES POTENTIELS
    @GetMapping(value = "/name/{name}")
    public List<EntityUser> getUserByLastName(@PathVariable("name") String name) {
        return serviceUser.findByLastName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityUser insertUser(@Valid @RequestBody EntityUser user) {
        // On supprime l'ID potentiellement tapé par l'utilisateur (il sera auto-généré par MongoDB lors de l'ajout).
        user.setId(null);
        return serviceUser.add(user);
    }

    @PutMapping(value = "/{id}")
    public EntityUser updateUser(@PathVariable("id") String id,
                                 @RequestBody EntityUser newUser) throws UserNotFoundException, UserValidationException {
        // Tous les champs de l'entité dans la requête remplaceront les anciennes valeurs de l'entité en base.
        EntityUser oldUser = serviceUser.findById(id);
        String newFirstName = newUser.getFirstName();
        String newLastName = newUser.getLastName();
        Date newBirthDay = newUser.getBirthDay();
        EntityUser.Position newPosition = newUser.getPosition();

        // Contrôle des informations.
        if (newFirstName != null && !newFirstName.isEmpty()) oldUser.setFirstName(newFirstName);
        if (newLastName != null && !newLastName.isEmpty()) oldUser.setLastName(newLastName);
        if (newBirthDay != null) {
            if (newBirthDay.before(new Date())) oldUser.setBirthDay(newBirthDay);
            else throw new UserValidationException("La date d'anniversaire ne peut pas être dans le turfu.");
        }
        if (newPosition != null) {
            if (newPosition.getLat() != null && newPosition.getLon() != null) oldUser.setPosition(newPosition); // A affiner théoriquement.
            else throw new UserValidationException("La position de l'utilisateur ne peut pas être vide.");
        }

        return serviceUser.update(oldUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") String id) throws UserException {
        /* Encapsulation de l'erreur spécifique UserNotFoundException dans l'erreur générique UserException dû à une mauvaise conception
        des tests client. */
        try {
            serviceUser.findById(id); // Pour trigger si nécessaire l'erreur UserNotFoundException.
            serviceUser.delete(id);
        } catch (UserNotFoundException e) {
            throw new UserException(e);
        }
    }

}
