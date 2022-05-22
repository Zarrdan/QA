package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Calculation {
    @JsonProperty("is_default")
    private boolean is_default;
    private float premium;
    @JsonProperty("data")
    Data DataObject;
    @JsonProperty("coeffs")
    Coeffs CoeffsObject;
    private boolean finished;
    ArrayList<Object> results = new ArrayList<>();
    ArrayList<Object> minikasko_results = new ArrayList<>();
}
