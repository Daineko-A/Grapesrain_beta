package by.grapesrain.services;

import by.grapesrain.entitys.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
public interface UserService extends UserDetailsService {

//    User findByLogin(String login);

    void save (User user);

    List<User> allUsers();

    Long getDepartamentBylogin(String login);
}
