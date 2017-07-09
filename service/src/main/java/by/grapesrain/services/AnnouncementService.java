package by.grapesrain.services;

import by.grapesrain.entitys.Announcement;

import java.util.List;

/**
 * Created by PloSkiY on 09.07.2017.
 */
public interface AnnouncementService {

    List<Announcement> allAnnouncements();

    Announcement findById(long id);
}
