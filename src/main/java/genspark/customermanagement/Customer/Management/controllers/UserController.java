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
        logger.trace("Method addUser: ");
        logger.debug("Adding user: ");
        try {
            User createdUser = this.userServ.createUser(user);
            logger.info("Success in adding user.");
            return createdUser;
        } catch (Exception e) {
            logger.error("Error in adding user.");
            throw e;
        }
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        logger.trace("Method updateUser: ");
        logger.debug("Updating user: ");
        try {
            User updatedUser = this.userServ.updateUser(user);
            logger.info("Success in updating user.");
            return updatedUser;
        } catch (Exception e) {
            logger.error("Error in updating user.");
            throw e;
        }
    }

    @GetMapping("/user/all")
    public List<User> allUsers() {
        logger.trace("Method allUsers: ");
        logger.debug("Getting all users");
        try {
            List<User> users = this.userServ.getAllUsers();
            logger.info("Success in getting all users.");
            return users;
        } catch (Exception e) {
            logger.error("Error in getting all users.");
            throw e;
        }
    }

    @GetMapping("/user/{id}")
    public Optional<User> getOneUser(@PathVariable Long id) {
        logger.trace("Method getOneUser: ");
        logger.debug("Getting user with id: {}", id);
        try {
            Optional<User> user = this.userServ.getOneUser(id);
            logger.info("Success in getting user with id: {}", id);
            return user;
        } catch (Exception e) {
            logger.error("Error in getting user by id.");
            throw e;
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        logger.trace("Method deleteUser: ");
        logger.debug("Deleting user with id: {}", id);
        try {
            String result = this.userServ.deleteUser(id);
            logger.info("Success in deleting user with id: {}", id);
            return result;
        } catch (Exception e) {
            logger.error("Error in deleting user.");
            throw e;
        }
    }

    @GetMapping("/user/name")
    public List<User> getUserByName(@RequestParam String name) {
        logger.trace("Method getUserByName: ");
        logger.debug("Getting user with name: {}", name);
        try {
            List<User> users = this.userServ.findByName(name);
            logger.info("Success in getting user by name: {}", name);
            return users;
        } catch (Exception e) {
            logger.error("Error in getting user by name.");
            throw e;
        }
    }

    @GetMapping("/user/email")
    public List<User> getUserByEmail(@RequestParam String email) {
        logger.trace("Method getUserByEmail: ");
        logger.debug("Getting user with email: {}", email);
        try {
            List<User> users = this.userServ.findByEmail(email);
            logger.info("Success in getting user by email: {}", email);
            return users;
        } catch (Exception e) {
            logger.error("Error in getting user by email.");
            throw e;
        }
    }

    @GetMapping("/user/phoneNumber")
    public List<User> getUserByPhoneNumber(@RequestParam String phoneNumber) {
        logger.trace("Method getUserByPhoneNumber: ");
        logger.debug("Getting user with phone number: {}", phoneNumber);
        try {
            List<User> users = this.userServ.findByPhoneNumber(phoneNumber);
            logger.info("Success in getting user by phone number: {}", phoneNumber);
            return users;
        } catch (Exception e) {
            logger.error("Error in getting user by phone number.");
            throw e;
        }
    }

}
