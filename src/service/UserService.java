package service;

import model.*;
import repository.*;
import model.User;
import repository.UserRepository;

import java.util.*;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User build(String userDetails) {
        String[] attributes = userDetails.split("/");
        String name = attributes[0];
        Boolean isPremium = Boolean.parseBoolean(attributes[1]);
        return new User(name, isPremium);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }
    public void deleteUser(User user)
    {
        userRepository.deleteUser(user.getName());
    }
}
