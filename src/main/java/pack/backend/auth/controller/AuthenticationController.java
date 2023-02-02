package pack.backend.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pack.backend.auth.AuthenticationRequest;
import pack.backend.auth.RegisterRequest;
import pack.backend.auth.service.AuthenticationService;
import pack.backend.dto.ResponseData;
import pack.backend.entity.user.UserEntity;
import pack.backend.pipe.ValidationPipe;

@Slf4j
@RestController
@RequestMapping("/user/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final ValidationPipe pipe;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<UserEntity>> registration(
            @Valid
            @RequestBody RegisterRequest request, Errors errors){
        ResponseData<UserEntity> responseRegister = new ResponseData<>();

        if(pipe.validation(errors, responseRegister)){
            return ResponseEntity.status(400).body(responseRegister);
        }

        UserEntity user = modelMapper.map(request, UserEntity.class);

        responseRegister.setStatus(true);
        responseRegister.setPayload(service.register(user));

        return ResponseEntity.status(200).body(responseRegister);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        try{
            service.authenticate(request);
            log.info("New request authenticate {}", request);
            log.info("Status : true");
            return ResponseEntity.status(200).body("Login success.");
        } catch (BadCredentialsException err){
            log.error("Request authenticate failed {}", request);
            log.warn("Status : false");
            return ResponseEntity.status(400).body(err.getMessage());
        }
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