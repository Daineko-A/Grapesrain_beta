package by.grapesrain.dao;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */

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
        user.setPassword("123456");
        user.setUserRole(userRoleDao.findAll().get(0));
        userDao.save(user);

        User findUser = userDao.findByLastName("dsa").get(0);
        assertEquals(findUser, user);
    }

    @Test
    public void findUserByLoginAndPass() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        UserRole userRole = new UserRole();
        userRole.setRole("Админ");
        userRoleDao.save(userRole);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");
        user.setUserRole(userRoleDao.findAll().get(0));

        userDao.save(user);

        User findUser = userDao.findUserByLoginAndPass("admin", "123456");
        assertEquals(findUser, user);

    }

    @Test
    public void findUserByLoginAndPassResultNull() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        UserRole userRole = new UserRole();
        userRole.setRole("Админ");
        userRoleDao.save(userRole);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");
        user.setUserRole(userRoleDao.findAll().get(0));

        userDao.save(user);

        User findUser = userDao.findUserByLoginAndPass("aadmin", "123456");
        assertNull(findUser);
    }

    @Test
    public void findUserByLogin() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        UserRole userRole = new UserRole();
        userRole.setRole("Админ");
        userRoleDao.save(userRole);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");
        user.setUserRole(userRoleDao.findAll().get(0));

        userDao.save(user);

        User findUser = userDao.findUserByLogin("admin");
        assertEquals(findUser, user);
    }
}
