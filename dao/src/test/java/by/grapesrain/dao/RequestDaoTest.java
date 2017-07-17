package by.grapesrain.dao;

import by.grapesrain.entitys.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by PloSkiY on 06.07.2017.
 */
public class RequestDaoTest extends BaseDaoTest {

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private DepartamentDao departamentDao;

    @Test
    public void findRequestsByDepartament() {
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        Request findRequest = requestDao.findRequestsByDepartament(departamentDao.findAll().get(0)).get(0);
        assertEquals(findRequest, request);
    }


    @Test
    public void allRequestsByDepWithPage(){
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        Request findRequest = requestDao.allRequestsByDepWithPage(0, 1, departamentDao.findAll().get(0)).get(0);
        assertNotNull(findRequest);
        assertEquals(findRequest, request);
    }

    @Test
    public void quantityRequests() {
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        int quantity = requestDao.quantityRequests(departamentDao.findAll().get(0), Status.OPEN);
        assertEquals(quantity, 1);
    }

    @Test
    public void allRequestsByDepWithPageWithoutClose() {
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        Request findRequest = requestDao.allRequestsByDepWithPageWithoutClose(0, 1, departamentDao.findAll().get(0)).get(0);
        assertNotNull(findRequest);
        assertEquals(findRequest, request);
    }


    @Test
    public void allRequestsByDepWithPageWithClose() {
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        List<Request> findRequest = requestDao.allRequestsByDepWithPageWithClose(0, 1, departamentDao.findAll().get(0));

        assertNull(findRequest);
    }

    @Test
    public void findById() {
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        Request findRequest = requestDao.findById(1);
        assertNotNull(findRequest);
    }

    @Test
    public void findAllRequest() {
        Departament departament = new Departament("ИТ");
        departamentDao.save(departament);

        Role role = new Role("Админ");
        roleDao.save(role);

        User user = new User("asd", "dsa", "login", "123456", "asd@Asd.asd", departamentDao.findAll().get(0));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(1));
        user.setRoles(roles);
        userDao.save(user);

        Request request = new Request("title", "body", userDao.findAll().get(0), Status.OPEN, departamentDao.findAll().get(0), Priority.HIGH);
        request.setExecutor(userDao.findAll().get(0));
        requestDao.save(request);

        Request findRequest = requestDao.findAll().get(0);
        assertNotNull(findRequest);
    }
}
