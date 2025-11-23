package bd.edu.seu.libraryms.bookallotment.controller;

import bd.edu.seu.libraryms.bookallotment.entity.BookAllotment;
import bd.edu.seu.libraryms.bookallotment.service.BookAllotmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book-allotment")
public class BookAllotmentController {

    private final BookAllotmentService service;

    public BookAllotmentController(BookAllotmentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model m) {
        m.addAttribute("items", service.getAll());
        return "bookallotment/list";
    }

    @GetMapping("/create")
    public String createPage(Model m) {
        m.addAttribute("item", new BookAllotment());
        return "bookallotment/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BookAllotment a) {
        service.save(a);
        return "redirect:/book-allotment";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model m) {
        m.addAttribute("item", service.getById(id));
        return "bookallotment/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/book-allotment";
    }
}
