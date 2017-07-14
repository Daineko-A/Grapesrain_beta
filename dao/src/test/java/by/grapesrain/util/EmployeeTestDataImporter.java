package by.grapesrain.util;

import by.grapesrain.dao.DepartamentDao;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Role;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by PloSkiY on 22.06.2017.
 */
public class EmployeeTestDataImporter{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private DepartamentDao departamentDao;

    public void importTestData() {
        Departament departament = new Departament();
        departament.setName("ИТ");
        departamentDao.save(departament);

        Role role = new Role();
        role.setRole("Админ");
        roleDao.save(role);

//        User user = new User();
//        user.setFirstName("asd");
//        user.setLastName("dsa");
//        user.setDepartament(departamentDao.findAll().get(0));
//        user.setEmail("asd@Asd.asd");
//        user.setPhoneNumber(375291234567L);
//        user.setPassword("123456");
//        user.setUserRole(roleDao.findAll().get(0));
//
//        userDao.save(user);



//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Departament it = new Departament("It");
//        Departament buhg = new Departament("Buhg");
//        Departament managers = new Departament ("Managers");
//
//        Role admin = new Role("Admin");
//        Role user = new Role("User");
//        Role client = new Role("Client");
//
//        User alex = new User("Alex", "LAlex", "123", 123456789, "asdf@adsf.bt");
//        User olga = new User("Olga", "LOlga", "321", 122435, "asdf@saf.sa");
//        User dima = new User("Dima", "LDima", "4321", 213432532, "sdf@adsf.com");
//
//
//        session.save(it);
//        session.save(buhg);
//        session.save(managers);
//
//        session.save(admin);
//        session.save(user);
//        session.save(client);
//
//        UserDaoImpl.getInstance().saveEntity(session, alex);
//        UserDaoImpl.getInstance().saveEntity(session, olga);
//        UserDaoImpl.getInstance().saveEntity(session, dima);
//
//        session.getTransaction().commit();
//        session.close();
    }
}
