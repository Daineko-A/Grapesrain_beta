package by.grapesrain.dao;

import by.grapesrain.entitys.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private RoleDao roleDao;

    @Autowired
    private DepartamentDao departamentDao;

    @Autowired
    private UserCardDao userCardDao;


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

        Role role = new Role();
        role.setRole("Админ");
        roleDao.save(role);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);

        userDao.save(user);

        User findUser = userDao.findByLastName("dsa").get(0);
        assertEquals(findUser, user);
    }

    @Test
    public void findUserByLoginAndPass() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        Role role = new Role();
        role.setRole("Админ");
        roleDao.save(role);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);

        userDao.save(user);

        User findUser = userDao.findUserByLoginAndPass("admin", "123456");
        assertEquals(findUser, user);

    }

    @Test
    public void findUserByLoginAndPassResultNull() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        Role role = new Role();
        role.setRole("Админ");
        roleDao.save(role);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);

        userDao.save(user);

        User findUser = userDao.findUserByLoginAndPass("aadmin", "123456");
        assertNull(findUser);
    }

    @Test
    public void findUserByLogin() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        Role role = new Role();
        role.setRole("Админ");
        roleDao.save(role);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);

        UserCard userCard = new UserCard();
        userCard.setFirstDevice(new Device("123", "321"));
        userCardDao.save(userCard);
        user.setUserCard(userCard);
        userDao.save(user);

        User findUser = userDao.findUserByLogin("admin");
        System.out.println(findUser.getUserCard());
        assertEquals(findUser, user);
    }

    @Test
    public void findUserCardByUser() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        Role role = new Role();
        role.setRole("Админ");
        roleDao.save(role);

        User user = new User();
        user.setFirstName("asd");
        user.setLastName("dsa");
        user.setLogin("admin");
        user.setDepartament(departamentDao.findAll().get(0));
        user.setEmail("asd@Asd.asd");
        user.setPassword("123456");

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        UserCard userCard = new UserCard();
        userCard.setFirstDevice(new Device("123", "321"));
        userCard.setUser(userDao.findUserByLogin("admin"));
        userCardDao.save(userCard);

        UserCard findUserCard = userCardDao.findUserCardByUser(userDao.findUserByLogin("admin"));
        assertNotNull(findUserCard);
    }
}
