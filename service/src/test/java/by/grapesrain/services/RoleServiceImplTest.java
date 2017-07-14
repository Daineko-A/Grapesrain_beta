package by.grapesrain.services;

import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TestConfigDB.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@javax.transaction.Transactional
public class RoleServiceImplTest {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void findAllRoles(){
        Role role = new Role();
        role.setRole("asd");
        roleDao.save(role);

        Role findRole = userRoleService.allUserRoles().get(0);
        assertNotNull(findRole);
    }
}
