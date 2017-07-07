package by.grapesrain.services;

import by.grapesrain.dao.UserRoleDao;
import by.grapesrain.entitys.UserRole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TestConfigDB.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@javax.transaction.Transactional
public class UserRoleServiceImplTest {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void findAllRoles(){
        UserRole userRole = new UserRole();
        userRole.setRole("asd");
        userRoleDao.save(userRole);

        UserRole findUserRole = userRoleService.allUserRoles().get(0);
        assertNotNull(findUserRole);
    }
}
