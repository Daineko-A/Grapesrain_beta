package by.grapesrain.services;

import by.grapesrain.dao.UserDao;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.entitys.Role;
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
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(2));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    @Override
    public Long getDepartamentBylogin(String login) {
        return userDao.findUserByLogin(login).getDepartament().getId();
    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for(Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return grantedAuthorities;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findUserByLogin(login);

        if(user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), getUserAuthorities(user));
    }
}
