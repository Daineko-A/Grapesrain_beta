package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.dao.common.BaseDaoImpl;
import by.grapesrain.entitys.BaseEntity;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
