package by.grapesrain.services;

import by.grapesrain.dao.UserDao;
import by.grapesrain.dao.UserRoleDao;
import by.grapesrain.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
    }


    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void save(User user) {
        user.setUserRole(userRoleDao.findAll().get(1));
        userDao.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().getRole()));

        return grantedAuthorities;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findUserByLogin(login);

        if(user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getUserAuthorities(user));
    }
}
