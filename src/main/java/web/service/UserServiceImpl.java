package web.service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.models.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getIdUser(Long id) {
        return userDao.getIdUser(id);
    }
}