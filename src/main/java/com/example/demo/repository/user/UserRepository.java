package com.example.demo.repository.user;

import com.example.demo.model.portfolio.Portfolio;
import com.example.demo.model.user.User;
import jakarta.validation.Valid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //void saveUser(User user);
    User getUserById(String id);
    //Set<@Valid Portfolio> getPortfolios();
}
