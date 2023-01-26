package pack.backend.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.backend.auth.AuthenticationRequest;
import pack.backend.auth.AuthenticationResponse;
import pack.backend.auth.service.AuthenticationService;
import pack.backend.auth.RegisterRequest;

@RestController
@RequestMapping("/user/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}