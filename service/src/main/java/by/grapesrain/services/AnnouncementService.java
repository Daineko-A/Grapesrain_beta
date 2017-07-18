package by.grapesrain.services;

import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;

import java.util.List;

/**
 * Created by PloSkiY on 09.07.2017.
 */
public interface AnnouncementService {

    List<Announcement> allAnnouncements();

    List<Announcement> allAnnouncementsByDep(Departament departament);

    Announcement findById(long id);

    void save(Announcement announcement, String login);

    List<Announcement> findAllActualByDep(Departament departament);

    List<Announcement> findAllPastByDep(Departament departament);
}
