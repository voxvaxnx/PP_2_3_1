package web.service;
import web.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.models.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public final UserDao userDAO;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> allUser() {
        return userDAO.index();
    }

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getIdUser(int id) {
        return userDAO.show(id);
    }
}