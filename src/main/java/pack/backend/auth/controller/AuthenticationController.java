package pack.backend.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.backend.auth.AuthenticationRequest;
import pack.backend.auth.AuthenticationResponse;
import pack.backend.auth.service.AuthenticationService;
import pack.backend.auth.RegisterRequest;

@RestController
@RequestMapping("/user/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    /**
     * Create method logout
     *
     * When user is logout the jwt is must be inactive
     * and then when user is trying to access the endpoint
     * user must login first and the spring will be give another jwt
     */
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(){return ResponseEntity.ok().build();}
}