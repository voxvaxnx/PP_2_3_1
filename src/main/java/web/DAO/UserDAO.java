package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show (int id);
    void save(User user);
    void delete(int id);
    void updateUser(int id, User user);
}
