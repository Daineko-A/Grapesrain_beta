package by.grapesrain.controller;

import by.grapesrain.entitys.User;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.UserRoleService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Alexandr on 19.07.2017.
 */
@Controller
public class EditUser {

    private final UserService userService;
    private final DepartamentService departamentService;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;

    @Autowired
    public EditUser(UserService userService, DepartamentService departamentService, PasswordEncoder passwordEncoder, UserRoleService userRoleService) {
        this.userService = userService;
        this.departamentService = departamentService;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
    }

    @ModelAttribute("user")
    public User newUser() {
        return new User();
    }

    @ModelAttribute("userDetails")
    public User userDetails(@PathVariable("userId") Long userId, Model model) {
        return userService.findById(userId);
    }

    @GetMapping("/useredit/{userId}")
    public String userPage() {
        return "edituser";
    }

    // POSTS
    @PostMapping("/useredit/{userId}")
    public String updateDeportament(Model model, User user) throws Exception {

        try {
//            userService.update(user);
        } catch (HibernateOptimisticLockingFailureException error){
            return "redirect:/errorpage";
        }

        return "redirect:/admin";
    }
}
