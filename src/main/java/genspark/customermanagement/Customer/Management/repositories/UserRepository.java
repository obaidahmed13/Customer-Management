package genspark.customermanagement.Customer.Management.repositories;

import genspark.customermanagement.Customer.Management.controllers.UserController;
import genspark.customermanagement.Customer.Management.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    List<User> findByEmail(String email);
    List<User> findByPhoneNumber(String phoneNumber);
    List<User> findByName(String name);

}
