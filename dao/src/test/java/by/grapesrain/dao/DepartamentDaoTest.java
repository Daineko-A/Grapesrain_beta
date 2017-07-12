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

    @Test
    public void findDepartamentById() {
        Departament departament = new Departament();
        departament.setName("it");
        departamentDao.save(departament);

        Departament findDepartament = departamentDao.findById(1);
        Departament departament2 = new Departament();
        departament2.setName("it");

        assertEquals(findDepartament.getName(), departament2.getName());
    }

    //TODO: Нужно придумать как закрыть сессию, пока всё в одной сессии.
    @Test
    public void saveDepartamentUseCache(){
        Departament departament = new Departament("it");
        departamentDao.save(departament);

        Departament departament1 = new Departament("man");
        departamentDao.save(departament1);

        Departament departament2 = new Departament("dev1");
        departamentDao.save(departament2);

        Departament departament3 = new Departament("dev2");
        departamentDao.save(departament2);

        Departament departament4 = new Departament("dev3");
        departamentDao.save(departament2);

        Departament departament5 = new Departament("dev4");
        departamentDao.save(departament2);



        Departament findDepartament1 = departamentDao.findAll().get(1);
        Departament findDepartament2 = departamentDao.findById(1);
        Departament findDepartament3 = departamentDao.findAll().get(2);
        Departament findDepartament4 = departamentDao.findAll().get(2);
        Departament findDepartament5 = departamentDao.findAll().get(2);
        Departament findDepartament6 = departamentDao.findAll().get(2);

        System.out.println(findDepartament1.getName());
        System.out.println(findDepartament2.getName());
        System.out.println(findDepartament3.getName());
        System.out.println(findDepartament4.getName());
        System.out.println(findDepartament5.getName());
        assertNotNull(findDepartament5);
    }
}
