package by.grapesrain.services;

import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
