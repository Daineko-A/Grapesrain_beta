package by.grapesrain.controller;

import by.grapesrain.entitys.Departament;
import by.grapesrain.services.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by PloSkiY on 12.07.2017.
 */
@Controller
public class DepartamentController {

    private final DepartamentService departamentService;

    @Autowired
    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @ModelAttribute("departamentDetails")
    public Departament departamentdetails(@PathVariable("departamentId") Integer departamentId) {
        return departamentService.findById(departamentId);
    }

    @ModelAttribute("departament")
    public Departament departament() {
        return new Departament();
    }

    @GetMapping("/departamentdetails/{departamentId}")
    public String requestPage(@PathVariable("departamentId") Integer requestId, Model model) {
        return "departamentdetails";
    }

    @PostMapping("/departamentdetails/{departamentId}")
    public String updateDeportament(Model model, Departament departament) throws Exception {
        try {
            departamentService.update(departament);
        } catch (HibernateOptimisticLockingFailureException error){
            return "redirect:/index";
        }

        return "redirect:/admin";
    }
}
