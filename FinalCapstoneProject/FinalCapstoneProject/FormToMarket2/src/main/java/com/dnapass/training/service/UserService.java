package com.dnapass.training.service;

import com.dnapass.training.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnapass.training.entity.User;
import com.dnapass.training.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        userRepository.save(user);
        return user;
    }

    public User login(String userId, String password, String role)
    {
        Login login = new Login(Integer.parseInt(userId), password, role);
        return this.findUser(login.getUserid());
    }

    public User findUser(Integer id)
    {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
        {
            return null;
        }
        return user.get();
    }
}
