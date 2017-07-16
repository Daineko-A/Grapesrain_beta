package by.grapesrain.controller;

import by.grapesrain.entitys.*;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.RequestAnswerService;
import by.grapesrain.services.RequestService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Controller
public class RequestRegController {

    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;
    private final RequestAnswerService requestAnswerService;

    @Autowired
    public RequestRegController(RequestService requestService, UserService userService, DepartamentService departamentService, RequestAnswerService requestAnswerService) {
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

    @ModelAttribute("newRequest")
    public Request request() {
        return new Request();
    }


    //GET
    @GetMapping("/requestform")
    public String requestForm() {
        return "requestform";
    }


    //POST
    @PostMapping("/requestform")
    public String createRequest(Request request, @RequestParam long departament) {

        String login = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        request.setDepartament(departamentService.findById(departament));
        request.setStatus(Status.OPEN);

        if(request.getTitle().isEmpty() && request.getBody().isEmpty()){
            return "redirect: /requestform";
        }

        requestService.save(request, login);
        return "redirect: /index";
    }
}
