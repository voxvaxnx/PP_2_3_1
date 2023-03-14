package org.example.springcourse.DAO;

import org.example.springcourse.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show (int id);
    void save(User user);
    void deleteUser(int id);
    void Edit();

    void updateUser(int id, User user);

}
