package by.grapesrain.util;

import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by PloSkiY on 22.06.2017.
 */
public class EmployeeTestDataImporter {

    private static EmployeeTestDataImporter INSTANCE;

    private EmployeeTestDataImporter() {
    }

    public static EmployeeTestDataImporter getInstance() {
        if (INSTANCE == null) {
            synchronized (EmployeeTestDataImporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EmployeeTestDataImporter();
                }
            }
        }
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Departament it = new Departament("It");
        Departament buhg = new Departament("Buhg");
        Departament managers = new Departament ("Managers");

        UserRole admin = new UserRole("Admin");
        UserRole user = new UserRole("User");
        UserRole client = new UserRole("Client");

        User alex = new User("Alex", "LAlex", "123", 123456789, "asdf@adsf.bt");
        User olga = new User("Olga", "LOlga", "321", 122435, "asdf@saf.sa");
        User dima = new User("Dima", "LDima", "4321", 213432532, "sdf@adsf.com");


        session.save(it);
        session.save(buhg);
        session.save(managers);

        session.save(admin);
        session.save(user);
        session.save(client);

        session.save(alex);
        session.save(olga);
        session.save(dima);

        session.getTransaction().commit();
        session.close();
    }
}
