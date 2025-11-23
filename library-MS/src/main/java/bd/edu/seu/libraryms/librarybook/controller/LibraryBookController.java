package bd.edu.seu.libraryms.librarybook.controller;

import bd.edu.seu.libraryms.librarybook.entity.LibraryBook;
import bd.edu.seu.libraryms.librarybook.service.LibraryBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library-books")
public class LibraryBookController {

    private final LibraryBookService service;

    public LibraryBookController(LibraryBookService service) {
        this.service = service;
    }

    // list page
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", service.findAll());
        return "librarybook/list";
    }

    // create form
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new LibraryBook());
        return "librarybook/create";
    }

    // edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        LibraryBook book = service.findById(id);
        if (book == null) {
            return "redirect:/library-books/list";
        }
        model.addAttribute("book", book);
        return "librarybook/create";
    }

    // save (create + update)
    @PostMapping("/save")
    public String save(@ModelAttribute("book") LibraryBook book) {

        // small helper: quantity 0 হলে status NOT_AVAILABLE
        if (book.getQuantity() == null) {
            book.setQuantity(0);
        }
        book.setStatus(book.getQuantity() > 0 ? "AVAILABLE" : "NOT_AVAILABLE");

        service.save(book);
        return "redirect:/library-books/list";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/library-books/list";
    }
}
