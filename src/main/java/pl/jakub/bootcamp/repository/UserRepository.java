package pl.jakub.bootcamp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.bootcamp.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findByName(String name);
    public List<User> findBySurname(String surname);
    public List<User> findByEmail(String email);
    public List<User> findByPhone(String phone);
    public List<User> findByCourse(String course);
    public List<User> findByType(String type);
    public List<User> findAll();


}
