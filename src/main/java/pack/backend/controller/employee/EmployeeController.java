package pack.backend.controller.employee;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pack.backend.pipe.ValidationPipe;
import pack.backend.dto.EmployeeDto;
import pack.backend.dto.EnumSearchData;
import pack.backend.dto.ResponseData;
import pack.backend.dto.SearchData;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee-data")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService service;
    private final ModelMapper modelMapper;
    private final ValidationPipe validationPipe;
    protected ResponseData<EmployeeEntity> responseData = new ResponseData<>();

    @Autowired
    public EmployeeController(EmployeeService service, ModelMapper modelMapper, ValidationPipe validationPipe) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.validationPipe = validationPipe;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseData<EmployeeEntity>> createNewEmployee(
            @Valid
            @RequestBody EmployeeDto employeeDto,
            Errors errors){

        if (validationPipe.validation(errors, responseData)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        EmployeeEntity employee = modelMapper.map(employeeDto, EmployeeEntity.class);

        responseData.setStatus(true);
        responseData.setPayload(service.createNewEmployee(employee));

        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping(path = "/get-all-employees")
    public ResponseEntity<Iterable<EmployeeEntity>> getAllEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllEmployee());
    }

    @GetMapping(path = "/get-employee-by-email")
    public ResponseEntity<Optional<EmployeeEntity>> findEmployeeByEmail(@RequestBody SearchData searchData){
        return ResponseEntity.status(HttpStatus.OK).body(service.findEmployeeByEmail(searchData.getSearchKey()));
    }

    @GetMapping(path = "/get-employee-by-role")
    public ResponseEntity<List<EmployeeEntity>> findEmployeeByJobRole(
            @Valid
            @RequestBody EnumSearchData enumSearchData){
        return ResponseEntity.status(200).body(service.findEmployeeByRole(enumSearchData.getRoleEnum()));
    }

    @PutMapping(path = "/update-employee")
    public ResponseEntity<ResponseData<EmployeeEntity>> updateEmployee(
            @Valid
            @RequestBody EmployeeEntity employeeEntity,
            Errors errors){
        if (validationPipe.validation(errors, responseData)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        responseData.setStatus(true);
        responseData.setPayload(service.updateEmployee(employeeEntity));

        return ResponseEntity.status(200).body(responseData);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id){
        service.deleteEmployeeById(id);
        return ResponseEntity.status(200).body(String.format("Employee with id %d has deleted", id));
    }
}
