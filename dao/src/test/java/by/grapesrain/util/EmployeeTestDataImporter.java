package by.grapesrain.util;

import org.hibernate.SessionFactory;

/**
 * Created by PloSkiY on 22.06.2017.
 */
public class EmployeeTestDataImporter {

    private static EmployeeTestDataImporter INSTANCE;

    private EmployeeTestDataImporter() {
    }

    public void importTestData(SessionFactory sessionFactory) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Departament it = new Departament("It");
//        Departament buhg = new Departament("Buhg");
//        Departament managers = new Departament ("Managers");
//
//        UserRole admin = new UserRole("Admin");
//        UserRole user = new UserRole("User");
//        UserRole client = new UserRole("Client");
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
