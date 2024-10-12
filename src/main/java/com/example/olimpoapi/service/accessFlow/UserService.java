package com.example.olimpoapi.service.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.postgresql.Administrator;
import com.example.olimpoapi.model.postgresql.User;
import com.example.olimpoapi.model.utils.Login;
import com.example.olimpoapi.repository.accessFlow.AdministratorRepository;
import com.example.olimpoapi.repository.accessFlow.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final AdministratorRepository administratorRepository;
    @Autowired
    private UserService(
            UserRepository userRepository,
            AdministratorRepository administratorRepository
    ) {
        this.userRepository = userRepository;
        this.administratorRepository = administratorRepository;
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
    public User findById(Long id) {
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

    public  Optional<User> findByCpf(String cpf) {
        Optional<User> user = userRepository.findByCpf(cpf);
        if (user.isEmpty()) {
            ExceptionThrower.throwNotFoundException("User not found");
        }
        return user;
    }
    public boolean verifyIfUserExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    public boolean verifyIfUserExistsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }

    public boolean verifyIfIsAdministrator(String customerCpf, Long communityId) {
        Optional<Administrator> administrator = administratorRepository.findByCustomerCpfAndCommunityId(
                customerCpf, communityId
        );
        if (administrator.isEmpty()) {
            ExceptionThrower.throwNotFoundException("Administrator not found");
        }
        return true;
    }

    public Administrator grantAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }
}
