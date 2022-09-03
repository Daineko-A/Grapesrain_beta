package by.grapesrain.services;

import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Departament;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
public class DepartamentServiceImplTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void allDepartaments() {
        Departament departament = new Departament("test");
        departamentService.save(departament);

        Departament findDepartament = departamentService.allDepartaments().get(0);
        assertNotNull(findDepartament);
    }

    @Test
    public void findById() {
        Departament departament = new Departament("test");
        departamentService.save(departament);

        Departament departament1 = new Departament("test1");
        departamentService.save(departament1);

        Departament findDepartament = departamentService.findById(2);
        assertEquals(findDepartament, departament1);
    }

    @Test
    public void save() {
        Departament departament = new Departament("test");
        departamentService.save(departament);

        Departament departament1 = new Departament("test1");
        departamentService.save(departament1);

        long size = departamentService.allDepartaments().size();
        assertEquals(size, 2);
    }

    @Test
    public void update() {
        Departament departament = new Departament("test");
        departamentService.save(departament);

        Departament findDepartament = departamentService.findById(1);
        findDepartament.setName("updated");

        Departament findUpdatedDepartament = departamentService.findById(1);
        assertEquals(findUpdatedDepartament.getName(), "updated");
    }
}
