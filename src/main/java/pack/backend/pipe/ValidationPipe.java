package pack.backend.pipe;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import pack.backend.dto.ResponseData;
import pack.backend.entity.employee.EmployeeEntity;

@Component
public class ValidationPipe {

    public boolean validation(Errors errors, ResponseData<EmployeeEntity> responseData) {
        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return true;
        }
        return false;
    }

}
