package bd.edu.seu.libraryms.inventory.controller;

import bd.edu.seu.libraryms.inventory.entity.InventoryRecord;
import bd.edu.seu.libraryms.inventory.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    //  Correct Constructor
    public InventoryController(InventoryService service) {
        this.service = service;
    }

    //  LIST PAGE
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("records", service.findAll());
        return "inventory/list";
    }

    //  CREATE PAGE
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("record", new InventoryRecord());
        return "inventory/create";
    }

    //  EDIT PAGE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        InventoryRecord record = service.findById(id);
        model.addAttribute("record", record);
        return "inventory/create";
    }

    //  SAVE (CREATE + UPDATE)
    @PostMapping("/save")
    public String save(@ModelAttribute("record") InventoryRecord record) {

        // Auto status add
        if ("ISSUE".equalsIgnoreCase(record.getActionType())) {
            record.setStatus("ACTIVE");
        } else if ("RETURN".equalsIgnoreCase(record.getActionType())) {
            record.setStatus("RETURNED");
        }

        service.save(record);
        return "redirect:/inventory/list";
    }

    //  DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/inventory/list";
    }
}
