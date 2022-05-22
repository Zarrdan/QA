package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Coeffs {
    @JsonProperty("Tbase_min")
    private float Tbase_min;
    @JsonProperty("Tbase_max")
    private float Tbase_max;
    @JsonProperty("Ktrailer")
    private float Ktrailer;
    @JsonProperty("Kregion")
    private float Kregion;
    @JsonProperty("Kengine")
    private float Kengine;
    @JsonProperty("Kexpage")
    private float Kexpage;
    @JsonProperty("Klim")
    private float Klim;
    @JsonProperty("Kterm")
    private float Kterm;
    @JsonProperty("Kbm")
    private float Kbm;
    @JsonProperty("kbm_class")
    private String kbm_class;
    @JsonProperty("S_min")
    private float S_min;

}
