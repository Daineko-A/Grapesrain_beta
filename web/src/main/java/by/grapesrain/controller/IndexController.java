package by.grapesrain.controller;

import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Role;
import by.grapesrain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import sun.plugin.liveconnect.SecurityContextHelper;

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

    @ModelAttribute("allReqByDepWithPageWithoutClose")
    public List<Request> requestsByDepWithPage() {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Departament dep = departamentService.findById(idDep);

        List<Request> requests = requestService.allRequestsByDepWithPageWithoutClose(0, 10, dep);
        return requests;
    }

    @ModelAttribute("allActualAnnouncement")
    public List<Announcement> allActualAnnouncement() {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Departament dep = departamentService.findById(idDep);

        return announcementService.findAllActualByDep(dep);
    }

    @ModelAttribute("allPastAnnouncement")
    public List<Announcement> allPastAnnouncement() {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Departament dep = departamentService.findById(idDep);

        return announcementService.findAllPastByDep(dep);
    }

    @ModelAttribute("allUserRole")
    public List<Role> userRoles() {
        return userRoleService.allUserRoles();
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        return "index";
    }
}
