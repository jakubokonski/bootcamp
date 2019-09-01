package pl.jakub.bootcamp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakub.bootcamp.model.User;
import pl.jakub.bootcamp.repository.UserRepository;
import pl.jakub.bootcamp.service.UserService;

@Service()
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
