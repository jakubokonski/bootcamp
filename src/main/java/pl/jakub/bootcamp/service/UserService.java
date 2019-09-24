package pl.jakub.bootcamp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jakub.bootcamp.model.User;
import pl.jakub.bootcamp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> search() {
        return userRepository.search("Jim", "Beam");
    }

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
//            case "course":
//                return userRepository.findByCourse(searchText);
            case "type":
                return userRepository.findByType(searchText);
            default:
                return userRepository.findAll();
        }
    }

}
