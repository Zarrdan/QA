package Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Result {
    @JsonProperty("parameters")
    Parameters ParametersObject;
    @JsonProperty("is_active")
    private boolean is_active;
    ArrayList<Object> available_payment_methods = new ArrayList<>();
    @JsonProperty("commission")
    Commission CommissionObject;
    private String error;
    private String error_description;
    private String error_type;
    private String error_code;
    private String detail;
}
