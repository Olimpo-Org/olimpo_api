package com.example.olimpoapi.service;

import com.example.olimpoapi.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgres.User;
import com.example.olimpoapi.model.redis.Login;
import com.example.olimpoapi.repository.LoginRepository;
import com.example.olimpoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    private UserService(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    public User login(Login login){
        Optional<Login> bdUser = getLogin(login.getEmail());

        if (bdUser.isPresent() && bdUser.get().getPassword().equals(login.getPassword())) {
            Optional<User> user = userRepository.findByEmail(login.getEmail());
            if (user.isPresent()) {
                return user.get();
            }else {
                ExceptionThrower.throwNullPointerException("User not found");
            }
        } else {
            ExceptionThrower.throwBadRequestException("Invalid email or password");
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
    public User getById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            ExceptionThrower.throwNotFoundException("User not found");
        }
        return user.get();
    }
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            ExceptionThrower.throwNotFoundException("User not found");
        }
        return user;
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public List<User> getByCommunityId(String communityId) {
        List<User> users = userRepository.findByCommunityId(communityId);
        if(users.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Users not found");
        }
        return users;
    }
    public Optional<Login> getLogin(String email) {
        Optional<Login> login = loginRepository.findById(email);
        return login;
    }
}
