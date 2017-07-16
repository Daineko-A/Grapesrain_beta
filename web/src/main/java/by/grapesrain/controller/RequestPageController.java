package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Priority;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Status;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.RequestAnswerService;
import by.grapesrain.services.RequestService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexandr on 16.07.2017.
 */
@Controller
public class RequestPageController {

    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;
    private final RequestAnswerService requestAnswerService;

    @Autowired
    public RequestPageController(RequestService requestService, UserService userService, DepartamentService departamentService, RequestAnswerService requestAnswerService) {
        this.requestService = requestService;
        this.userService = userService;
        this.departamentService = departamentService;
        this.requestAnswerService = requestAnswerService;
    }

    //Models
    @ModelAttribute("statuses")
    public List<Status> statuses() {
        List<Status> statuses = new ArrayList<Status>(Arrays.asList(Status.values()));
        return statuses;
    }

    @ModelAttribute("priorityes")
    public List<Priority> priorities() {
        List<Priority> priorities = new ArrayList<Priority>(Arrays.asList(Priority.values()));
        return priorities;
    }

    @ModelAttribute("departaments")
    public List<Departament> departaments() {
        return departamentService.allDepartaments();
    }

    @ModelAttribute("allReqByDepWithPage")
    public List<Request> requestsByDepWithPage(@PathVariable("page") Integer page) {
        long idDep = userService.getDepartamentBylogin(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Departament dep = departamentService.findById(idDep);
        int quantityReq = requestService.quantityRequests(dep);
        int startR = 0;

        List<Request> requests = requestService.allRequestsByDepWithPageWithautClose(startR, 5, dep);
        return requests;
    }



    @GetMapping("/requestopen/{page}")
    public String requestsOpenToPage() {
        return "requestlistopen";
    }

    @GetMapping("/requestclose/{page}")
    public String requestsCloseToPage() {
        return "requestlistclose";
    }
}
