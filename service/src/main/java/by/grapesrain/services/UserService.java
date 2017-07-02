package by.grapesrain.services;

import by.grapesrain.entitys.User;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
public interface UserService {

    User findByName(String name);

    void save (User user);
}
