package by.grapesrain.services;

import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserCard;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by PloSkiY on 01.07.2017.
 */
public interface UserService extends UserDetailsService {

    User findByLogin(String login);

    User findById(Long id);

    void save(User user);

    List<User> allUsers();

    Long getDepartamentBylogin(String login);

    UserCard getUserCardByUser(User user);
}
