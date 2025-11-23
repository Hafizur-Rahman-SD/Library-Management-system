package bd.edu.seu.libraryms.subscription.controller;

import bd.edu.seu.libraryms.subscription.entity.Subscription;
import bd.edu.seu.libraryms.subscription.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("subscriptions", service.findAll());
        return "subscription/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("subscription", new Subscription());
        return "subscription/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("subscription", service.findById(id));
        return "subscription/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("subscription") Subscription subscription) {
        service.save(subscription);
        return "redirect:/subscriptions/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/subscriptions/list";
    }
}
