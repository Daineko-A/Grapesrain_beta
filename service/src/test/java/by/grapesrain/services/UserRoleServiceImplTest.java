package by.grapesrain.services;

import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
public class UserRoleServiceImplTest extends BaseServiceTest {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void findAllRoles() {
        Role role = new Role("asd");
        ;
        roleDao.save(role);

        Role findRole = userRoleService.allUserRoles().get(0);
        assertNotNull(findRole);
    }
}
