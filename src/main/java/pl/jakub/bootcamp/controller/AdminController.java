package pl.jakub.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakub.bootcamp.model.User;
import pl.jakub.bootcamp.service.CourseService;
import pl.jakub.bootcamp.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/user-list")
    public String userList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @PostMapping("/user-list")
    public String searchUser(@RequestParam String searchText,
                             @RequestParam String searchParameter,
                             Model model) {
        model.addAttribute("users", userService.search());
        return "user-list";
    }

    @GetMapping("/courses-list")
    public String coursesList(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses-list";
    }

}
