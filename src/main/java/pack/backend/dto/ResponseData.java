package pack.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData<T> {
    private Boolean status;
    private List<String> messages = new ArrayList<>();
    private T payload;
}
