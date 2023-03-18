package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getIdUser(Long id);

    void save(User user);

    void delete(Long id);

    void updateUser(User user);
}
