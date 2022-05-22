package Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Parameters {
    private String premium;
    private String segment;
    @JsonProperty("warning")
    Warning WarningObject;
    @JsonProperty("commission")
    Commission CommissionObject;
    @JsonProperty("is_egarant")
    private boolean is_egarant;
    private float end_calculation;
    @JsonProperty("result_parameters")
    Result_parameters Result_parametersObject;
    @JsonProperty("start_calculation")
    private float start_calculation;
    private String integrated_agency_code;
    private String integrated_company_code;
    @JsonProperty("is_check_status_allowed")
    private boolean is_check_status_allowed;
    private String integrated_company_title;
    private String dnd;
    private String message;
    @JsonProperty("buy_availability")
    private boolean buy_availability;
}
