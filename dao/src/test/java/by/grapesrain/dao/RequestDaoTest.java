package by.grapesrain.dao;

import by.grapesrain.entitys.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

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
//    List<Request> findRequestsByDepartament(Departament departament);

    }


    @Test
    public void allRequestsByDepWithPage(){
//    List<Request> allRequestsByDepWithPage(int startR, int limitR, Departament departament);

    }

    @Test
    public void quantityRequests() {
//    public int quantityRequests(Departament departament);

    }

    @Test
    public void findById() {
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

        Request request = new Request();
        request.setTitle("title");
        request.setBody("body");
        request.setClose(LocalDateTime.of(2017, 02, 12, 14, 30));
        request.setCreator(userDao.findAll().get(0));
        request.setExecutor(userDao.findAll().get(0));
        request.setPriority(Priority.HIGH);
        request.setStatus(Status.OPEN);
        requestDao.save(request);

        System.out.println(request);

        Request findRequest = requestDao.findById(1);
        System.out.println(findRequest.getClass().getSimpleName());

        assertNotNull(findRequest);
    }

    @Test
    public void findAllRequest() {
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

        Request request = new Request();
        request.setTitle("title");
        request.setBody("body");
        request.setClose(LocalDateTime.of(2017, 02, 12, 14, 30));
        request.setCreator(userDao.findAll().get(0));
        request.setExecutor(userDao.findAll().get(0));
        request.setPriority(Priority.HIGH);
        request.setStatus(Status.OPEN);
        requestDao.save(request);

        System.out.println(request);

        Request findRequest = requestDao.findAll().get(0);
        System.out.println(findRequest);

        assertNotNull(findRequest);
    }
}
