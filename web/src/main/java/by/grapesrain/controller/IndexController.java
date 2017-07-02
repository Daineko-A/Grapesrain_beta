package by.grapesrain.controller;

import by.grapesrain.entitys.UserRole;
import by.grapesrain.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by Alexandr on 02.07.2017.
 */
@Controller
public class IndexController {

    @Autowired
    private UserRoleService userRoleService;

    @ModelAttribute("allUserRole")
    public List<UserRole> userRoles() {
        return userRoleService.allUserRoles();
    }

    @GetMapping("/index")
    public String indexPage() {
        return "hello";
    }
}
