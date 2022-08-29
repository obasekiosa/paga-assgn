package com.example.pagaassgn.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserCredRepository credRepository;


    @Autowired
    public UserService(UserRepository userRepository, UserCredRepository userCredRepository) {
        this.userRepository = userRepository;
        this.credRepository = userCredRepository;
    }

    public User addNewUser(String username, String password) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public User getUser(String username) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean deleteUser(String username) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean updatePassword(String username, String newPassword) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }
}
