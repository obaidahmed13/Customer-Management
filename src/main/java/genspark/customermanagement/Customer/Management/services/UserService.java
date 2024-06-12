package genspark.customermanagement.Customer.Management.services;

import genspark.customermanagement.Customer.Management.models.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getOneUser(Long id);
    User updateUser(User user);
    String deleteUser(Long id);
    List<User> findByName(String name);
    List<User> findByPhoneNumber(String phoneNumber);
    List<User> findByEmail(String email);


}
