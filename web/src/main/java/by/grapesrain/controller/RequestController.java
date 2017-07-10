package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Status;
import by.grapesrain.entitys.User;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.RequestService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Controller
public class RequestController {

    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;

    @Autowired
    public RequestController(RequestService requestService, UserService userService, DepartamentService departamentService) {
        this.requestService = requestService;
        this.userService = userService;
        this.departamentService = departamentService;
    }

    @ModelAttribute("statuses")
    public List<Status> statuses() {
        List<Status> statuses = new ArrayList<Status>(Arrays.asList(Status.values()));
        return statuses;
    }

    @ModelAttribute("departaments")
    public List<Departament> departaments() {
        return departamentService.allDepartaments();
    }



    @ModelAttribute("request")
    public Request request(@PathVariable("requestId") Integer requestId) {
        return requestService.findById(requestId);
    }


    @GetMapping("/request/{requestId}")
    public String requestPage(@PathVariable("requestId") Integer requestId, Model model) {
        return "request";
    }
}
