package web.DAO;

import web.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImplementation implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> index(){ //отдаем список
        return entityManager.createQuery("FROM User").getResultList();
    }
    @Override
    public User show (int id) {
        return entityManager.find(User.class, id);

    }
    @Override
    public void save(User user) { //метод для сохранения объекта Person
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User userSearch = entityManager.find(User.class, id);
        userSearch.setName(user.getName());
        userSearch.setLastname(user.getLastname());
        }

    @Override

    public void delete(int id) {
        entityManager.remove(show(id));

    }
}
