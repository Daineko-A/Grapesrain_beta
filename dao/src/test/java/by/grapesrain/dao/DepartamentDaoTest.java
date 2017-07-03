package by.grapesrain.dao;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created by PloSkiY on 03.07.2017.
 */
public class DepartamentDaoTest extends BaseDaoTest {

    @Autowired
    private DepartamentDao departamentDao;

    @Test
    public void saveDepartament(){
        Departament departament = new Departament();
        departament.setName("it");

        departamentDao.save(departament);

        Departament findDepartament = departamentDao.findAll().get(0);
        assertNotNull(findDepartament);
    }
}
