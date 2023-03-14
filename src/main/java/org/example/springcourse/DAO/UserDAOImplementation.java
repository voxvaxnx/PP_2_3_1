package org.example.springcourse.DAO;

import org.example.springcourse.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAOImplementation implements UserDAO {
    private static int PEOPLE_COUNT;
    private List<User> people;


    { //статический блок добавления Person в список
        people = new ArrayList<>();
        people.add(new User(++PEOPLE_COUNT, "Tom", "Tomasson"));
        people.add(new User(++PEOPLE_COUNT, "Jerry", "Jeferson"));
        people.add(new User(++PEOPLE_COUNT, "Spike", "Spikerton"));
        people.add(new User(++PEOPLE_COUNT, "Babka", "V_Tapkah"));

    }

    public List<User> index(){ //отдаем список
        //...код для получаем из базы данных
        return people;
    }
    public User show (int id) {  //отдаем список по id используем стримы и лямбды
        //...код для получаем из базы данных по id
        return people.stream().filter(user -> user.getId() == id).findAny().orElse(null);

    }
    public void save(User user) { //метод для сохранения объекта Person
        //...код для сохраняем в базу данных
       user.setId(++PEOPLE_COUNT);
       people.add(user);
    }
    public void deleteUser(int id){
        people.remove(id);
    }

    @Override
    public void Edit() {

    }

    @Override
    public void updateUser(int id, User user) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastname(user.getLastname());
    }
}
