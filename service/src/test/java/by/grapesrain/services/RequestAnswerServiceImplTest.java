package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandr on 17.07.2017.
 */
public class RequestAnswerServiceImplTest extends BaseServiceTest {

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
    public void save() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);
        Request request = new Request("zxc", "asd", user, Status.OPEN, departament, Priority.HIGH);
        requestService.save(request, "zxc");

        RequestAnswer requestAnswer = new RequestAnswer(request, user, "zxcv");
        requestAnswerService.save(requestAnswer, "zxc");

        RequestAnswer findRequestAnswer = requestAnswerService.findByRequest(request).get(0);
        assertEquals(findRequestAnswer.getBody(), "zxcv");
    }

    @Test
    public void findByRequest() {
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

        RequestAnswer requestAnswer = new RequestAnswer(request, user, "zxcv");
        requestAnswerService.save(requestAnswer, "zxc");
        RequestAnswer requestAnswer2 = new RequestAnswer(request, user, "zxcv");
        requestAnswerService.save(requestAnswer2, "zxc");
        RequestAnswer requestAnswer3 = new RequestAnswer(request1, user, "zxcv");
        requestAnswerService.save(requestAnswer3, "zxc");

        int size = requestAnswerService.findByRequest(request).size();
        assertEquals(size, 2);
    }
}
