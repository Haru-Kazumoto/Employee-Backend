package pack.backend.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pack.backend.dto.ResponseData;
import pack.backend.dto.UserDto;
import pack.backend.entity.user.UserEntity;
import pack.backend.service.user.UserService;

@RestController
@RequestMapping(path = "/user-data")
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/register")
    private ResponseEntity<ResponseData<UserEntity>> register(
            @Valid @RequestBody UserDto userDto, Errors errors){

        ResponseData<UserEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
        }

        UserEntity user = modelMapper.map(userDto, UserEntity.class);

        responseData.setStatus(true);
        responseData.setPayload(service.registerUser(user));
        responseData.getMessages().add("NEW USER CREATED.");

        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}