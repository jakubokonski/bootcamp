package pl.jakub.bootcamp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.bootcamp.model.Course;
import pl.jakub.bootcamp.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    List<User> findByEmail(String email);
    List<User> findByPhone(String phone);
    List<User> findByCourse(Course course);
    List<User> findByType(String type);
    List<User> findAll();

    @Query("select u from User u where u.name=?1 and u.surname=?2")
    List<User> search(String name, String surname);


}
