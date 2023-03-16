package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
        @GetMapping()
        public String index() { //получим всех людей из DAO и передаем на отображение
            return "/hello";
    }
}
