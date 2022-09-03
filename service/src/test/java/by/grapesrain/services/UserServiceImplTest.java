package by.grapesrain.services;

import by.grapesrain.dao.RoleDao;
import by.grapesrain.dao.UserCardDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Device;
import by.grapesrain.entitys.Role;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserCard;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
public class UserServiceImplTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserCardDao userCardDao;

    @Test
    public void save() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        User findUser = userService.allUsers().get(0);
        assertEquals(findUser, user);
    }

    @Test
    public void allUsers() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        User findUser = userService.allUsers().get(0);
        assertNotNull(findUser);
    }

    @Test
    public void getDepartamentBylogin() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        user.setDepartament(departamentService.allDepartaments().get(0));

        userService.save(user);

        UserCard userCard = new UserCard();
        userCard.setFirstDevice(new Device("123", "321"));

        userCard.setUser(userService.findByLogin("zxc"));
        userCardDao.save(userCard);

        Departament findDepartament = departamentService.findById(userService.getDepartamentBylogin("zxc"));
        assertEquals(findDepartament, departament);
    }

    @Test
    public void getUserCardByUser() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        user.setDepartament(departamentService.allDepartaments().get(0));

        userService.save(user);

        UserCard userCard = new UserCard();
        userCard.setFirstDevice(new Device("123", "321"));

        userCard.setUser(userService.findByLogin("zxc"));
        userCardDao.save(userCard);

        UserCard findUserCard = userService.getUserCardByUser(userService.findByLogin("zxc"));
        assertEquals(findUserCard, userCard);
    }
}
