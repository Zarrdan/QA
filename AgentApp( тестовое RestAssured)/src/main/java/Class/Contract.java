package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Contract {
    private String id;
    private String origin = null;
    private String valid_from;
    private String valid_to;
    ArrayList< Object > periods = new ArrayList <> ();
    @JsonProperty("calculation")
    Calculation CalculationObject;
    private String status;
    private String insured_object = null;
    private String prolongation = null;
}
