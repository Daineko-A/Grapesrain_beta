package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.UserRoleService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Controller
public class AdminController {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final DepartamentService departamentService;


    @Autowired
    public AdminController(UserService userService, UserRoleService userRoleService, DepartamentService departamentService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.departamentService = departamentService;
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return userService.allUsers();
    }

    @ModelAttribute("allDepartaments")
    public List<Departament> allDepartaments() {
        return departamentService.allDepartaments();
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
