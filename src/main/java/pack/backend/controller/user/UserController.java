package pack.backend.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pack.backend.dto.UserDto;
import pack.backend.entity.user.UserEntity;
import pack.backend.service.employee.user.UserService;

@RestController
@RequestMapping(path = "/user/data")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<Iterable<UserDto>> getAllUser(){
        return null;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        return ResponseEntity.status(200).body(service.deleteUserById(id));
    }
}
