package genspark.customermanagement.Customer.Management.controllers;

import genspark.customermanagement.Customer.Management.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import genspark.customermanagement.Customer.Management.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userServ;

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        logger.debug("Adding user: {}", user);
        return this.userServ.createUser(user);
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        logger.debug("Updating user: {}", user);
        return this.userServ.updateUser(user);
    }

    @GetMapping("/user/all")
    public List<User> allUsers() {
        logger.debug("Getting all users");
        return this.userServ.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getOneUser(@PathVariable Long id) {
        logger.debug("Getting user with id: {}", id);
        return this.userServ.getOneUser(id);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        logger.debug("Deleting user with id: {}", id);
        return this.userServ.deleteUser(id);
    }

    @GetMapping("/user/name")
    public List<User> getUserByName(@RequestParam String name) {
        logger.debug("Getting user with name: {}", name);
        return this.userServ.findByName(name);
    }

    @GetMapping("/user/email")
    public List<User> getUserByEmail(@RequestParam String email) {
        logger.debug("Getting user with email: {}", email);
        return this.userServ.findByEmail(email);
    }

    @GetMapping("/user/phoneNumber")
    public List<User> getUserByPhoneNumber(@RequestParam String phoneNumber) {
        logger.debug("Getting user with phone number: {}", phoneNumber);
        return this.userServ.findByPhoneNumber(phoneNumber);
    }

}
