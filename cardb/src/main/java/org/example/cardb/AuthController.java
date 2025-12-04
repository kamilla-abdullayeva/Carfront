package org.example.cardb;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        // Простейшая проверка (для теста)
        if (("user".equals(request.getUsername()) && "user".equals(request.getPassword())) ||
                ("admin".equals(request.getUsername()) && "admin".equals(request.getPassword()))) {

            String token = jwtService.generateToken(request.getUsername());

            // Возвращаем токен в теле
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
