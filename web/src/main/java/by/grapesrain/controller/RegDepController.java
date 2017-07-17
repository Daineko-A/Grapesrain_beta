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
 * Created by Alexandr on 17.07.2017.
 */
@Controller
public class RegDepController {

    private final DepartamentService departamentService;

    @Autowired
    public RegDepController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @ModelAttribute("departament")
    public Departament departament() {
        return new Departament();
    }


    //GETS
    @GetMapping("/regdepartament")
    public String regDepPage() {
        return "regdepartament";
    }


    // POSTS
    @PostMapping("/regdepartament")
    public String regDeportament(Model model, Departament departament) {
        departamentService.save(departament);
        return "redirect:/admin";
    }
}
