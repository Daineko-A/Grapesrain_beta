package by.grapesrain.dao;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
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

    //TODO: Нужно придумать как закрыть сессию, пока всё в одной сессии.
    @Test
    public void saveDepartamentUseCache(){
        Departament departament = new Departament();
        departament.setName("it");
        departamentDao.save(departament);

        Departament departament1 = new Departament();
        departament1.setName("man");
        departamentDao.save(departament1);

        Departament departament2 = new Departament();
        departament2.setName("dev1");
        departamentDao.save(departament2);

        Departament findDepartament3 = departamentDao.findAll().get(1);
        Departament findDepartament = departamentDao.findById(1);
        Departament findDepartament2 = departamentDao.findAll().get(2);

        System.out.println(findDepartament);
        assertNotNull(findDepartament);
    }
}
