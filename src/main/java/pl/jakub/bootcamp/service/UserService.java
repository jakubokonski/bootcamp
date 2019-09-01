package pl.jakub.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakub.bootcamp.model.User;
import pl.jakub.bootcamp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

//    public List<User> findByName(String name) {
//        return userRepository.findByName(name);
//    }
//
//    public List<User> findBySurname(String surname) {
//        return userRepository.findBySurname(surname);
//    }

    public List<User> searchUser(String searchText, String searchParameter) {
        switch (searchParameter) {
            case "name":
                return userRepository.findByName(searchText);
            case "surname":
                return userRepository.findBySurname(searchText);
            case "email":
                return userRepository.findByEmail(searchText);
            case "phone":
                return userRepository.findByPhone(searchText);
            case "course":
                return userRepository.findByCourse(searchText);
            case "type":
                return userRepository.findByType(searchText);
            default:
                return userRepository.findAll();
        }
    }

}
