package web.controllers;

import web.models.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() { //получим всех людей из DAO и передаем на отображение
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/index";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getIdUser(id));
        return "/show";
    }

    @GetMapping("/users/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("User") User user) {
        userService.addUser(user);
        return "redirect:/users";

    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getIdUser(id));
        return "/edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
