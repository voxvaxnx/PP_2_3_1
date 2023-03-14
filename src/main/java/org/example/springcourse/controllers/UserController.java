package org.example.springcourse.controllers;

import org.example.springcourse.DAO.UserDAO;
import org.example.springcourse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO;
    @Autowired //можно не писать так как у конструктора автоматом @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()  //тут ничего нет потому что есть @RequestMapping("/people")
    public String index(Model model){ //получим всех людей из DAO и передаем на отображение
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) { // Метод извлекает 1го человека из DAO по id и передаем на отображение
        model.addAttribute("user", userDAO.show(id));
        return "users/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model) { //Метод возвращает форму создания нового пользователя
        model.addAttribute("user", new User());
        return "users/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){  // Метод за счет аннотации @ModelAttribute создает в модели объект Person и из тела Post запроса(формы) задает объекту Person поля через сеттеры
        userDAO.save(user);                                     // а тут мы сохраняем обьект в базу или список или ?
        return "redirect:/users"; //осуществляем редирект по ключевому слову redirect:

    }
}
