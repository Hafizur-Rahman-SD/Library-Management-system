package bd.edu.seu.libraryms.auth.controller;

import bd.edu.seu.libraryms.auth.dto.LoginRequest;
import bd.edu.seu.libraryms.auth.dto.RegisterRequest;
import bd.edu.seu.libraryms.auth.entity.User;
import bd.edu.seu.libraryms.auth.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute RegisterRequest req,
                                 Model model) {
        try {
            service.register(req);
            return "redirect:/auth/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "auth/register";
        }
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }


}
