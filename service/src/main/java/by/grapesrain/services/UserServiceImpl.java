package by.grapesrain.services;

import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.User;
import by.grapesrain.entitys.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().getRole()));

        return grantedAuthorities;
    }

//    public UserDetails loadUserByLoginAndPass(String login, String password) throws UsernameNotFoundException {
//        User user = userDao.findUserByLoginAndPass(login, password);
//
//        if(user == null) {
//            throw new UsernameNotFoundException("Пользователь не найден");
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getUserAuthorities(user));
//    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findUserByLogin(login);

        if(user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getUserAuthorities(user));
    }
}
