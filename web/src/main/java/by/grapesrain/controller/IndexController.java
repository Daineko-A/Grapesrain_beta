package by.grapesrain.controller;

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

    @ModelAttribute("requestsByDep")
    public List<Request> reqByDep() {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return requestService.findRequestsByDepartament(departamentService.findById(idDep));
    }

    @ModelAttribute("allRequests")
    public List<Request> requests() {
        return requestService.allRequests();
    }

    @ModelAttribute("allReqByDepWithPage")
    public List<Request> requestsByDepWithPage(@PathVariable("page") Integer page) {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Departament dep = departamentService.findById(idDep);
        int quantityReq = requestService.quantityRequests(dep);

//        int page = 0;
        int startR = 0;
        int limit = 5;

        System.out.println("------------------------------------>" + page);
//        startR = limit * page;

        List<Request> requests = requestService.allRequestsByDepWithPage(startR, limit, dep);
        return requests;
    }

    @ModelAttribute("pages")
    public int pages() {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Departament dep = departamentService.findById(idDep);
        return requestService.quantityRequests(dep);
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
