package com.example.olimpoapi.service.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.model.utils.Login;
import com.example.olimpoapi.repository.accessFlow.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User login(Login login){
        Optional<User> dbUser = findByEmail(login.getEmail());
        if (dbUser.isPresent()){
            User user = dbUser.get();
            if (user.getPassword().equals(login.getPassword())){
                user.setPassword(null);
                return user;
            } else {
                ExceptionThrower.throwNotFoundException("User not found");
            }
        } else {
            ExceptionThrower.throwNotFoundException("User not found");
        }
        return null;
    }
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Users not found");
        }
        return users;
    }
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            ExceptionThrower.throwNotFoundException("User not found");
        }
        return user.get();
    }
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            ExceptionThrower.throwNotFoundException("User not found");
        }
        return user;
    }
    public boolean verifyIfUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
