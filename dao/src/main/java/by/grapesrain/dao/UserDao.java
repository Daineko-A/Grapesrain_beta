package by.grapesrain.dao;

import by.grapesrain.entitys.BaseEntity;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

/**
 * Created by PloSkiY on 21.06.2017.
 */
public class UserDao {


    private static UserDao INSTANCE;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    //saveUser
    public void saveEntity(Session session, BaseEntity baseEntity){
        session.saveOrUpdate(baseEntity);
    }

    public List<UserRole> findAllRole(Session session) {
        return session
                .createQuery("select ur from UserRole ur", UserRole.class)
                .getResultList();
    }

    public List<User> findAllUsers(Session session) {
        return session
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<Departament> findAllDepartaments(Session session) {
        return session
                .createQuery("select d from Departament d", Departament.class)
                .getResultList();
    }
}
