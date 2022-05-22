package Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Warning {
    @JsonProperty("parameters")
    Parameters ParametersObject;
    @JsonProperty("warning_code")
    private String warning_code;
}
