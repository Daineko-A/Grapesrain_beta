package by.grapesrain.dao;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private DepartamentDao departamentDao;

    @Test
    public void saveUser(){
        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");

        userDao.save(user);

        User findUser = userDao.findAll().get(0);
        assertNotNull(findUser);
    }

    @Test
    public void findByLastName() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        UserRole userRole = new UserRole();
        userRole.setRole("Админ");
        userRoleDao.save(userRole);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPhoneNumber(375291234567L);
        user.setPassword("12345");
        user.setUserRole(userRoleDao.findAll().get(0));

        userDao.save(user);

        User findUser = userDao.findByLastName("dsa").get(0);
        System.out.println(findUser.getId());
        System.out.println(findUser.getDepartament().getName());
        assertEquals(findUser, user);
    }
}
