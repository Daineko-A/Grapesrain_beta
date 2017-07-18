package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by PloSkiY on 07.07.2017.
 */
@Controller
public class RegistrationController {

    private final UserService userService;
    private final DepartamentService departamentService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, DepartamentService departamentService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.departamentService = departamentService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("allDepartaments")
    public List<Departament> allDepartaments() {
        return departamentService.allDepartaments();
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @ModelAttribute("departament")
    public Departament departament() {
        return new Departament();
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user, Model model, @RequestParam long departament) {
        user.setDepartament(departamentService.findById(departament));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "login";
    }
}
