package by.grapesrain.services;

import by.grapesrain.entitys.UserRole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
@RunWith(SpringRunner.class)
@Transactional
public class UserRoleServiceImplTest {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void findAllRoles(){
        UserRole userRole = userRoleService.allUserRoles().get(1);
        assertNotNull(userRole);
    }
}
