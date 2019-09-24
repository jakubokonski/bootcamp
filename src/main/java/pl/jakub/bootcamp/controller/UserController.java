package pl.jakub.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakub.bootcamp.model.User;
import pl.jakub.bootcamp.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", User.builder()
                .build());
        return "register";
    }

    @PostMapping("/registration-result")
    public String registrationResult(@Valid @ModelAttribute User user,
                                     BindingResult bindingResult,
                                     Model model) {
        model.addAttribute("user", user);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "registration-result";
    }


}
