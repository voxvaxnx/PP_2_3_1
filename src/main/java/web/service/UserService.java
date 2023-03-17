package web.service;
import web.models.User;
import java.util.List;

public interface UserService {
    public List<User> allUser();//показать юзеров

    public void addUser(User user);//добавить юзеров

    public void deleteUser(int id);//удалить юзеров

    public void updateUser(User user);//изменить юзеров

    public User getIdUser(int id);//получить по id юзеров
}
