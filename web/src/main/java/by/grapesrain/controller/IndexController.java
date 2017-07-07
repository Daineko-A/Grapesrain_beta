package by.grapesrain.controller;

import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.UserRole;
import by.grapesrain.services.RequestService;
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

    private final UserRoleService userRoleService;
    private final RequestService requestService;

    @Autowired
    public IndexController(UserRoleService userRoleService, RequestService requestService) {
        this.userRoleService = userRoleService;
        this.requestService = requestService;
    }

    @ModelAttribute("allRequests")
    public List<Request> requests() {
        return requestService.allRequests();
    }

    @ModelAttribute("allUserRole")
    public List<UserRole> userRoles() {
        return userRoleService.allUserRoles();
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }
}
