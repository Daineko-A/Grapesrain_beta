package by.grapesrain.controller;

import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.UserRole;
import by.grapesrain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

/**
 * Created by Alexandr on 02.07.2017.
 */
@Controller
public class IndexController {

    private final UserRoleService userRoleService;
    private final AnnouncementService announcementService;
    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;

    @Autowired
    public IndexController(UserRoleService userRoleService, RequestService requestService, AnnouncementService announcementService, UserService userService, DepartamentService departamentService) {
        this.userRoleService = userRoleService;
        this.requestService = requestService;
        this.announcementService = announcementService;
        this.userService = userService;
        this.departamentService = departamentService;
    }

    @ModelAttribute("requestsByDep")
    public List<Request> reqByDep() {
        return requestService.findRequestsByDepartament(departamentService.findById(1));
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
