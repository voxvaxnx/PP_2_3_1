package web.Dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(int id);

    void save(User user);

    void delete(int id);

    void updateUser(User user);
}
