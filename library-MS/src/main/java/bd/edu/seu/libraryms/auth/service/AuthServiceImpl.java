package bd.edu.seu.libraryms.auth.service;

import bd.edu.seu.libraryms.auth.dto.LoginRequest;
import bd.edu.seu.libraryms.auth.dto.RegisterRequest;
import bd.edu.seu.libraryms.auth.entity.User;
import bd.edu.seu.libraryms.auth.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    //  REGISTER
    @Override
    public User register(RegisterRequest req) {

        // password match check
        if (!req.getPassword().equals(req.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match!");
        }

        // username exists check
        if (userRepo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }

        // create user
        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setUsername(req.getUsername());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setRole("USER");

        User saved = userRepo.save(u);

        // terminal log
        System.out.println("=== NEW USER REGISTERED ===");
        System.out.println("ID       : " + saved.getId());
        System.out.println("FullName : " + saved.getFullName());
        System.out.println("Email    : " + saved.getEmail());
        System.out.println("Username : " + saved.getUsername());
        System.out.println("Password : " + saved.getPassword());
        System.out.println("Role     : " + saved.getRole());

        return saved;
    }

    //  LOGIN
    @Override
    public User login(LoginRequest req) {

        // find user
        User u = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // password match check
        if (!passwordEncoder.matches(req.getPassword(), u.getPassword())) {
            throw new RuntimeException("Wrong password!");
        }

        // terminal log
        System.out.println("=== LOGIN SUCCESS ===");
        System.out.println("Username : " + u.getUsername());

        return u;
    }
}
