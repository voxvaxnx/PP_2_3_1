package web.service;

import web.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserService {
    public List<User> allUser();//показать юзеров
    public void  addUser(User user);//добавить юзеров
    public void deleteUser(int id);//удалить юзеров
    public void updateUser(int id, User user);//изменить юзеров
    public User getIdUser(int id);//получить по id юзеров
}
