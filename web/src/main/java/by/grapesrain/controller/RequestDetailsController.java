package by.grapesrain.controller;

import by.grapesrain.entitys.*;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.RequestAnswerService;
import by.grapesrain.services.RequestService;
import by.grapesrain.services.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexandr on 16.07.2017.
 */
@Controller
public class RequestDetailsController {

    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;
    private final RequestAnswerService requestAnswerService;

    @Autowired
    public RequestDetailsController(RequestService requestService, UserService userService, DepartamentService departamentService, RequestAnswerService requestAnswerService) {
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

    @ModelAttribute("newAnswer")
    public RequestAnswer requestAnswer() {
        return new RequestAnswer();
    }
    
    @ModelAttribute("rqAnswers")
    public List<RequestAnswer> requestAnswers(@PathVariable("requestId") Integer requestId) {
        return requestAnswerService.findByRequest(requestService.findById(requestId));
    }

    @ModelAttribute("findRequest")
    public Request findRequest(@PathVariable("requestId") Integer requestId) {
        return requestService.findById(requestId);
    }

    //W
    @PostMapping("/request/{requestId}")
    public String createAnswer(Model model,
                               RequestAnswer requestAnswer,
                               @RequestParam String status,
                               @RequestParam String priority,
                               @RequestParam Integer reqId) {

        String executor = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        if(requestAnswer.getBody().isEmpty()){
            return "redirect: redirect: /request/{requestId}";
        }

        Request request = requestService.findById(reqId);

        request.setStatus(Status.valueOf(status));
        request.setPriority(Priority.valueOf(priority));
        requestService.update(request, executor, request.getCreator().getLogin());

        requestAnswer.setRequest(request);
        requestAnswerService.save(requestAnswer, executor);

        return "redirect: /request/{requestId}";
    }

    @GetMapping("/request/{requestId}")
    public String requestPage() {
        return "request";
    }
}
