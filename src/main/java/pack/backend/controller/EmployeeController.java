package pack.backend.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pack.backend.dto.EmployeeDto;
import pack.backend.dto.ResponseData;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.service.employee.EmployeeService;

@RestController
@RequestMapping(path = "/employee-data")
public class EmployeeController {

    private final EmployeeService service;
    private final ModelMapper modelMapper;
    protected ResponseData<EmployeeEntity> responseData = new ResponseData<>();

    @Autowired
    public EmployeeController(EmployeeService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseData<EmployeeEntity>> createNewEmployee(
            @Valid
            @RequestBody EmployeeDto employeeDto,
            Errors errors){
        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        EmployeeEntity employee = modelMapper.map(employeeDto, EmployeeEntity.class);

        responseData.setStatus(true);
        responseData.setPayload(service.createNewEmployee(employee));

        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping(path = "/get-all-employees")
    public ResponseEntity<Iterable<EmployeeEntity>> getAllEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllEmployee());
    }
}
