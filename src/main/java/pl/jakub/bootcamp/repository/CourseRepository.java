package pl.jakub.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.bootcamp.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
