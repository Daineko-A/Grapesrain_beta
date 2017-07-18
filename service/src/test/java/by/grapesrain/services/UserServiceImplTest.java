package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.dao.DepartamentDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@TestPropertySource(locations = "classpath:database.properties")
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartamentService departamentService;

    @Test
    public void save(){
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        userService.save(user);

        User findUser = userService.allUsers().get(0);
        assertNotNull(findUser);
//        assertEquals(findUser, user);
    }

    @Test
    public void allUsers(){
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        userService.save(user);

        User findUser = userService.allUsers().get(0);
        assertNotNull(findUser);
    }

    @Test
    public void getDepartamentBylogin(){
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        user.setDepartament(departamentService.allDepartaments().get(0));
        userService.save(user);


        long id = userService.getDepartamentBylogin("zxc");

//        Departament findDepartament = departamentService.findById(id);
        assertNotNull(id);
    }

//    Long getDepartamentBylogin(String login);
}
