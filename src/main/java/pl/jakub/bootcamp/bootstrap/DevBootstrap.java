package pl.jakub.bootcamp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.jakub.bootcamp.model.Course;
import pl.jakub.bootcamp.model.enums.CourseMode;
import pl.jakub.bootcamp.model.enums.Role;
import pl.jakub.bootcamp.model.User;
import pl.jakub.bootcamp.repository.CourseRepository;
import pl.jakub.bootcamp.repository.UserRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        init();
    }

    private void init() {
        Course course = Course.builder()
                .title("Java Basic")
                .description("Kurs Java od podstaw.")
                .courseMode(CourseMode.DAY)
                .build();
        courseRepository.save(course);

        Course course2 = Course.builder()
                .title("Java Advanced")
                .description("Kurs Java dla zaawansowanych.")
                .courseMode(CourseMode.EVENING)
                .build();
        courseRepository.save(course2);

        Course course3 = Course.builder()
                .title("Python Basic")
                .description("Kurs Python od podstaw")
                .courseMode(CourseMode.ONLINE)
                .build();
        courseRepository.save(course3);

        User admin = User.builder()
                .name("Jim")
                .surname("Beam")
                .email("jimbeam@gmail.com")
                .phone("555555555")
                .course(course2)
                .userName("Jim")
                .password("qwerty")
                .role(Role.ADMIN)
                .build();
        userRepository.save(admin);

        User student1 = User.builder()
                .name("Jack")
                .surname("Daniels")
                .email("jack@gmail.com")
                .phone("555666888")
                .course(course)
                .userName("Jack")
                .password("asdfg")
                .role(Role.USER)
                .build();
        userRepository.save(student1);

        User coach = User.builder()
                .name("Johnny")
                .surname("Walker")
                .email("johnny@gmail.com")
                .phone("5557778888")
                .course(course3)
                .userName("Johnny")
                .password("zxcvbn")
                .role(Role.COACH)
                .build();
        userRepository.save(coach);
    }
}
