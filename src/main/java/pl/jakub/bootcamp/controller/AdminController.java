package pl.jakub.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakub.bootcamp.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-list")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }


    @PostMapping("/user-list")
    public String searchUser(@RequestParam String searchText,
                             @RequestParam String searchParameter,
                             Model model) {
        model.addAttribute("users", userService.searchUser(searchText, searchParameter));
        return "user-list";
    }

}
