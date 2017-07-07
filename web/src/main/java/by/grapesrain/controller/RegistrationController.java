package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by PloSkiY on 07.07.2017.
 */
@Controller
public class RegistrationController {

    private final UserService userService;
    private final DepartamentService departamentService;

    @Autowired
    public RegistrationController(UserService userService, DepartamentService departamentService) {
        this.userService = userService;
        this.departamentService = departamentService;
    }

    @ModelAttribute("allDepartaments")
    public List<Departament> allDepartaments() {
        return departamentService.allDepartaments();
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return userService.allUsers();
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(User user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getLogin());
//        userService.save(user);
        return "registration";
    }
}
