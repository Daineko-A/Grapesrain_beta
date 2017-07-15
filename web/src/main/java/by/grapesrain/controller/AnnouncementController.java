package by.grapesrain.controller;

import by.grapesrain.entitys.Announcement;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;
import by.grapesrain.entitys.Status;
import by.grapesrain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PloSkiY on 10.07.2017.
 */
@Controller
public class AnnouncementController {

    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;
    private final RequestAnswerService requestAnswerService;
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(RequestService requestService, UserService userService, DepartamentService departamentService, RequestAnswerService requestAnswerService, AnnouncementService announcementService) {
        this.requestService = requestService;
        this.userService = userService;
        this.departamentService = departamentService;
        this.requestAnswerService = requestAnswerService;
        this.announcementService = announcementService;
    }

    @ModelAttribute("departaments")
    public List<Departament> departaments() {
        return departamentService.allDepartaments();
    }

    @ModelAttribute("announcement")
    public Announcement announcement() {
        return new Announcement();
    }

    @GetMapping("/announcementform")
    public String requestForm() {
        return "announcementform";
    }

    @PostMapping("/announcementform")
    public String createRequest(Announcement announcement, @RequestParam long departament) {
        String login = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        announcement.setDepartament(departamentService.findById(departament));

        if(announcement.getTitle().isEmpty() && announcement.getBody().isEmpty()){
            return "redirect: /announcementform";
        }

        announcementService.save(announcement, login);
        return "redirect: /index";
    }
}
