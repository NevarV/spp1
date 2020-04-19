package com.spp.server.spp1.controllers;

import com.spp.server.spp1.entity.User;
import com.spp.server.spp1.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MainController {

    private UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public String main(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "main";
    }

    @PostMapping("users")
    public RedirectView addUser(User user) {
        userRepository.save(user);
        return new RedirectView("users");
    }

    @DeleteMapping(path="users/{id}")
    public @ResponseBody
    void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("update")
    public String updateUser(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("adults")
    public String getAdults(Model model) {
        List<User> users = userRepository.findByAgeAfter(17);
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "main";
    }
}
