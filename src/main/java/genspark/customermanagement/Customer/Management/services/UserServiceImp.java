package genspark.customermanagement.Customer.Management.services;

import genspark.customermanagement.Customer.Management.controllers.UserController;
import genspark.customermanagement.Customer.Management.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import genspark.customermanagement.Customer.Management.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    UserRepository userRepo;

    @Override
    public User createUser(User user) {
        logger.debug("Creating user: {}", user);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        logger.debug("Getting all users");
        return this.userRepo.findAll();
    }

    @Override
    public Optional<User> getOneUser(Long id) {
        logger.debug("Getting user with id: {}", id);
        return this.userRepo.findById(id);
    }

    @Override
    public User updateUser(User user) {
        logger.debug("Updating user: {}", user);
        return this.userRepo.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        logger.debug("Deleting user with id: {}", id);
        return "User deleted successfully.";
    }

    @Override
    public List<User> findByName(String name) {
        logger.debug("Finding user by name: {}", name);
        return this.userRepo.findByName(name);
    }

    @Override
    public List<User> findByPhoneNumber(String phoneNumber) {
        logger.debug("Finding user by phone number: {}", phoneNumber);
        return this.userRepo.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<User> findByEmail(String email) {
        logger.debug("Finding user by email: {}", email);
        return this.userRepo.findByEmail(email);
    }
}
