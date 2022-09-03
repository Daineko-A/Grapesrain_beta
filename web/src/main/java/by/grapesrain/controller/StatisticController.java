package by.grapesrain.controller;

import by.grapesrain.services.AnnouncementService;
import by.grapesrain.services.DepartamentService;
import by.grapesrain.services.RequestService;
import by.grapesrain.services.UserRoleService;
import by.grapesrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Alexandr on 17.07.2017.
 */
@Controller
public class StatisticController {

    private final UserRoleService userRoleService;
    private final AnnouncementService announcementService;
    private final RequestService requestService;
    private final UserService userService;
    private final DepartamentService departamentService;

    @Autowired
    public StatisticController(UserService userService, DepartamentService departamentService, UserRoleService userRoleService, RequestService requestService, AnnouncementService announcementService) {
        this.userService = userService;
        this.departamentService = departamentService;
        this.userRoleService = userRoleService;
        this.requestService = requestService;
        this.announcementService = announcementService;
    }

    @GetMapping("/statistics")
    public String indexPage() {
        return "statistics";
    }
}
