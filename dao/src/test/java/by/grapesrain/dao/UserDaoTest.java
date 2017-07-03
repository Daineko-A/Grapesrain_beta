package by.grapesrain.dao;

import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
public class UserDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void saveUser(){
        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");

        userDao.save(user);

        User findUser = userDao.findAll().get(0);
        assertNotNull(findUser);
    }
}
