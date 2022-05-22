package Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Result_parameters {
    private String policyId;
    @JsonProperty("CalculationId")
    private String CalculationId;
    private float valid_from_days;
}
