package web.service;
import web.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    public final UserDAO userDAO;

    @Autowired
    public UserServiceImplementation(UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    @Override
    @Transactional
    public List<User> allUser() {
        return userDAO.index();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }

    @Override
    @Transactional
    public User getIdUser(int id) {
        return userDAO.show(id);
    }
}