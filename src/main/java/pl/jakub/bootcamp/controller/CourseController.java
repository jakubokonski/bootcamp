package pl.jakub.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakub.bootcamp.model.Course;
import pl.jakub.bootcamp.service.CourseService;

@Controller
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/add-course")
    public String addCourse(Model model) {
        model.addAttribute("course", Course.builder().build());
        return "add-course";
    }

    @PostMapping("/add-course")
    public String addCourse(@ModelAttribute Course course, Model model) {
        model.addAttribute("course", course);
        courseService.save(course);
        return "courses-list";
    }

}
