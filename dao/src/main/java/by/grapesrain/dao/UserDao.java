package by.grapesrain.dao;

import by.grapesrain.dao.common.BaseDao;
import by.grapesrain.entitys.User;

import java.util.List;

/**
 * Created by Alexandr on 30.06.2017.
 */
public interface UserDao extends BaseDao<User> {

    List<User> findByLastName(String lastName);

    User findUserByLoginAndPass(String login, String password);

    User findUserByLogin(String login);
}
