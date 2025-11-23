package bd.edu.seu.libraryms.vendor.controller;

import bd.edu.seu.libraryms.vendor.entity.Vendor;
import bd.edu.seu.libraryms.vendor.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("vendors", service.findAll());
        return "vendor/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Vendor vendor) {
        service.save(vendor);
        return "redirect:/vendors/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("vendor", service.findById(id));
        return "vendor/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/vendors/list";
    }
}
