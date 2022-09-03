package by.grapesrain.services;

import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Priority;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Role;
import by.grapesrain.entitys.Status;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 16.07.2017.
 */
public class RequestServiceImplTest extends BaseServiceTest {

    @Autowired
    private RequestAnswerService requestAnswerService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void allRequests() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");

        Request findRequest = requestService.allRequests().get(0);
        assertNotNull(findRequest);
    }

    @Test
    public void findById() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");

        Request findRequest = requestService.findById(1);
        assertEquals(findRequest, request);
    }

    @Test
    public void save() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");

        Request findRequest = requestService.findById(1);
        assertEquals(findRequest.getCreator(), user);
    }

    @Test
    public void quantityRequests() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");
        Request request1 = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request1, "zxc");

        int size = requestService.quantityRequests(departament, Status.OPEN);
        assertEquals(size, 2);
    }

    @Test
    public void update() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");

        Request updatedRequest = requestService.findById(1);
        updatedRequest.setTitle("updated");
        requestService.update(updatedRequest, "zxc", "zxc");

        Request findRequest = requestService.findById(1);
        assertEquals(findRequest.getTitle(), "updated");
    }

    @Test
    public void allRequestsWithPage() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");
        Request request1 = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request1, "zxc");

        int size = requestService.allRequestsWithPage(0, 1).size();
        assertEquals(size, 1);
    }

    @Test
    public void findRequestsByDepartament() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");
        Request request1 = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request1, "zxc");

        Request findRequest = requestService.findRequestsByDepartament(departament).get(0);
        assertEquals(findRequest.getDepartament(), departament);
    }

    @Test
    public void allRequestsByDepWithPage() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");

        Request findRequest = requestService.allRequestsByDepWithPage(0, 3, departament).get(0);
        assertEquals(findRequest.getDepartament(), departament);
    }

    @Test
    public void allRequestsByDepWithPageWithoutClose() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");
        Request request1 = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request1, "zxc");

        int size = requestService.allRequestsByDepWithPageWithoutClose(0, 5, departament).size();
        assertEquals(size, 2);
    }

    @Test
    public void allRequestsByDepWithPageWithClose() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");
        Request request1 = new Request("zxc", "asd", user, Status.CLOSED, departament, Priority.HIGH);
        requestService.save(request1, "zxc");

        int size = requestService.allRequestsByDepWithPageWithClose(0, 5, departament).size();
        assertEquals(size, 1);
    }
}
