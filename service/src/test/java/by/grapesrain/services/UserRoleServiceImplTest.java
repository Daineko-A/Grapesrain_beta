package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@TestPropertySource(locations = "classpath:database.properties")
@Transactional
public class UserRoleServiceImplTest {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void findAllRoles(){
        Role role = new Role("asd");;
        roleDao.save(role);

        Role findRole = userRoleService.allUserRoles().get(0);
        assertNotNull(findRole);
    }
}
