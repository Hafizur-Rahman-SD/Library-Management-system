package bd.edu.seu.libraryms.purchase.controller;

import bd.edu.seu.libraryms.purchase.entity.PurchaseBook;
import bd.edu.seu.libraryms.purchase.service.PurchaseBookService;
import bd.edu.seu.libraryms.vendor.entity.Vendor;
import bd.edu.seu.libraryms.vendor.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchase")
public class PurchaseBookController {

    private final PurchaseBookService service;
    private final VendorService vendorService;

    public PurchaseBookController(PurchaseBookService service, VendorService vendorService) {
        this.service = service;
        this.vendorService = vendorService;
    }

    @GetMapping("/list")
    public String listPage(Model model) {
        model.addAttribute("books", service.findAll());
        return "purchase/list";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("purchaseBook", new PurchaseBook());
        model.addAttribute("vendors", vendorService.findAll());
        return "purchase/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PurchaseBook book) {

        Vendor v = vendorService.findById(book.getVendor().getId());
        book.setVendor(v);

        book.setInvoiceNumber("INV-" + System.currentTimeMillis());

        service.save(book);

        return "redirect:/purchase/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/purchase/list";
    }
}
