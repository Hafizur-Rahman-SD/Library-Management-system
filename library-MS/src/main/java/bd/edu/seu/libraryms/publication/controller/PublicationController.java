package bd.edu.seu.libraryms.publication.controller;

import bd.edu.seu.libraryms.publication.entity.Publication;
import bd.edu.seu.libraryms.publication.service.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationService service;

    public PublicationController(PublicationService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("publications", service.findAll());
        return "publication/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("publication", new Publication());
        return "publication/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Publication p = service.findById(id);
        model.addAttribute("publication", p);
        return "publication/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("publication") Publication publication) {
        service.save(publication);
        return "redirect:/publications/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/publications/list";
    }
}
