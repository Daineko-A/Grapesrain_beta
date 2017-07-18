package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.User;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.UserRoleService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ModelAttribute("userDetails")
    public User userDetails() {
        return userService.findByLogin("Admin");
    }

    @GetMapping("/userdetails")
    public String userPage() {
        return "userdetails";
    }




//    @ModelAttribute("allDepartaments")
//    public List<Departament> allDepartaments() {
//        return departamentService.allDepartaments();
//    }
//
//    @ModelAttribute("userDetailsAdm")
//    public User userDetailsAdm(@PathVariable("userId") Integer userId) {
//        return userService.findById(Long.valueOf(userId));
//    }
//
//    @ModelAttribute("userDetails")
//    public User userDetails() {
//        return userService.findByLogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
//    }
//
//    @ModelAttribute("user")
//    public User user() {
//        return new User();
//    }
//
//    @GetMapping("/userdetails")
//    public String userPage() {
//        return "userdetails";
//    }
//
//    @GetMapping("/userdetailsadm/{userId}")
//    public String userPageAdmin(@RequestParam long userId) {
//        return "userdetailsadm/{userId}";
//    }
//
//    @PostMapping("/userdetailsadm/{userId}")
//    public String registerUser(User user, Model model, @RequestParam long userId) {
////        user.setDepartament(departamentService.findById(departament));
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
////        userService.save(user);
//        return "userdetails";
//    }
}
