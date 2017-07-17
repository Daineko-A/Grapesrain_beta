package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.entitys.User;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alexandr on 17.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@Transactional
public class UserServiceImplTest {

//    void save (User user);
//
//    List<User> allUsers();
//
//    Long getDepartamentBylogin(String login);
}
