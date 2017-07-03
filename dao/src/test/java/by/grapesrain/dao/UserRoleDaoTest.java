package by.grapesrain.dao;

import by.grapesrain.entitys.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
public class UserRoleDaoTest extends BaseDaoTest {

    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void findAllUserRole() {
        UserRole userRole = userRoleDao.findAll().get(1);
        assertNotNull(userRole);
    }
}
