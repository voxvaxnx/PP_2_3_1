package web.Dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(Long id);

    void save(User user);

    void delete(Long id);

    void updateUser(User user);
}
