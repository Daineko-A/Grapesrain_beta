package by.grapesrain.services;

import by.grapesrain.entitys.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
public interface UserService extends UserDetailsService {

    User findByName(String name);

    void save (User user);

    List<User> allUsers();
}
