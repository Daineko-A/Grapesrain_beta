package by.grapesrain.dao;

import by.grapesrain.entitys.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
public class RoleDaoTest extends BaseDaoTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void findAllUserRole() {
        Role role = new Role();
        role.setRole("Admin");

        roleDao.save(role);

        Role admin = roleDao.findAll().get(0);
        assertNotNull(admin);
    }

    @Test
    public void findByRoleName(){
        Role role = new Role();
        role.setRole("Admin");

        roleDao.save(role);

        Role admin = roleDao.findByRoleName("Admin");
        assertNotNull(admin);
    }
}
