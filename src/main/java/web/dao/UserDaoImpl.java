package web.dao;
import web.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getIdUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) { //метод для сохранения объекта Person
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
    entityManager.remove(getIdUser(id));

    }
}
