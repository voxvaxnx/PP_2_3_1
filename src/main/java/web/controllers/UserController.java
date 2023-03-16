package web.controllers;

import web.models.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @Autowired //можно не писать так как у конструктора автоматом @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()  //тут ничего нет потому что есть @RequestMapping("/people")
    public String index(Model model){ //получим всех людей из DAO и передаем на отображение
        model.addAttribute("users", userService.allUser());
        return "/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) { // Метод извлекает 1го человека из DAO по id и передаем на отображение
        model.addAttribute("user", userService.getIdUser(id));
        return "/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model) { //Метод возвращает форму создания нового пользователя
        model.addAttribute("user", new User());
        return "/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("User") User user){  // Метод за счет аннотации @ModelAttribute создает в модели объект Person и из тела Post запроса(формы) задает объекту Person поля через сеттеры
        userService.addUser(user);                                     // а тут мы сохраняем обьект в базу или список или ?
        return "redirect:/users"; //осуществляем редирект по ключевому слову redirect:

    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user" , userService.getIdUser(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.updateUser(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
