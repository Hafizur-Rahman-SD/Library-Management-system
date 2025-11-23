package bd.edu.seu.libraryms.auth.service;

import bd.edu.seu.libraryms.auth.dto.LoginRequest;
import bd.edu.seu.libraryms.auth.dto.RegisterRequest;
import bd.edu.seu.libraryms.auth.entity.User;

public interface AuthService {

    User register(RegisterRequest req);

    User login(LoginRequest req);
}
