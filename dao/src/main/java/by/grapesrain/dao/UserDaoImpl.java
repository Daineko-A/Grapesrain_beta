package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PloSkiY on 21.06.2017.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {


    @Override
    public List<User> findByLastName(String lastName) {
        List<User> users = getSessionFactory().getCurrentSession().createQuery(
                "select u from User u where u.lastName=:lastName", User.class)
                .setParameter("lastName", lastName)
                .getResultList();

        return users.size() > 0 ? users : null;
    }

    @Override
    public User findUserByLoginAndPass(String login, String password) {
        List<User> users = getSessionFactory().getCurrentSession().createQuery(
                "select u from User u where u.login=:login and u.password=:password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList();

        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User findUserByLogin(String login) {
        List<User> users = getSessionFactory().getCurrentSession().createQuery(
                "select u from User u where u.login=:login", User.class)
                .setParameter("login", login)
                .getResultList();

        return users.size() > 0 ? users.get(0) : null;
    }
}
