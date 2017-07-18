package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Role;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
public class AnnouncementServiceImplTest extends BaseServiceTest {

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private RoleDao roleDao;


    @Test
    public void allAnnouncements() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        Announcement announcement = new Announcement("zxc", "asd", user, LocalDateTime.now(), LocalDateTime.now(), departament);
        announcementService.save(announcement, "zxc");

        Announcement findAnnouncement = announcementService.allAnnouncements().get(0);
        assertNotNull(findAnnouncement);
    }

    @Test
    public void allAnnouncementsByDep() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Departament departament1 = new Departament("test1");
        departamentService.save(departament1);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        Announcement announcement = new Announcement("zxc", "asd", user, LocalDateTime.now(), LocalDateTime.now(), departament);
        announcementService.save(announcement, "zxc");

        Announcement announcement1 = new Announcement("zxc", "asd", user, LocalDateTime.now(), LocalDateTime.now(), departament1);
        announcementService.save(announcement1, "zxc");

        long size = announcementService.allAnnouncementsByDep(departament).size();
        assertEquals(size, 1);
    }

    @Test
    public void findById() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        Announcement announcement = new Announcement("zxc", "asd", user, LocalDateTime.now(), LocalDateTime.now(), departament);
        announcementService.save(announcement, "zxc");

        Announcement findAnnouncement = announcementService.findById(1);
        assertEquals(findAnnouncement, announcement);
    }

    @Test
    public void save() {
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        Announcement announcement = new Announcement("zxc", "asd", user, LocalDateTime.now(), LocalDateTime.now(), departament);
        announcementService.save(announcement, "zxc");

        Announcement findAnnouncement = announcementService.allAnnouncements().get(0);
        assertEquals(findAnnouncement, announcement);
    }
}
