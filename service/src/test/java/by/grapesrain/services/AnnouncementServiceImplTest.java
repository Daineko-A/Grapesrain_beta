package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alexandr on 17.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@Transactional
public class AnnouncementServiceImplTest {

//    List<Announcement> allAnnouncements();
//
//    List<Announcement> allAnnouncementsByDep(Departament departament);
//
//    Announcement findById(long id);
//
//    void save(Announcement announcement, String login);
}
