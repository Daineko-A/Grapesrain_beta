package by.grapesrain.controller;

import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.UserRoleService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Controller
public class UserController {

    private final UserService userService;
    private final DepartamentService departamentService;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;

    @Autowired
    public UserController(UserService userService, DepartamentService departamentService, PasswordEncoder passwordEncoder, UserRoleService userRoleService) {
        this.userService = userService;
        this.departamentService = departamentService;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
    }

    @GetMapping("/userdetails")
    public String indexPage() {
        return "userdetails";
    }
}
