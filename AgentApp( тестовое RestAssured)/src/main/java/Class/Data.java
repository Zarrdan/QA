package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Data {
    private String valid_from;
    private String valid_to;
    private float insurance_period;
    private String target_of_using;
    ArrayList<Object> drivers_ids = new ArrayList<>();
    @JsonProperty("is_car_without_registration")
    private boolean is_car_without_registration;
    private float engine_power;
    private boolean has_car_trailer;
    private String car_type;
    @JsonProperty("owner_registration")
    Owner_registration Owner_registrationObject;
    private String periods = null;
    ArrayList<Object> drivers = new ArrayList<>();
    private float max_mass;
    private float seats_count;
    @JsonProperty("is_multidrive")
    private boolean is_multidrive;
    private String insurance_period_kterm;
    private float insurance_period_month;
    private String insurant_type;
    private float kbm;
    @JsonProperty("is_kbm_request_with_error")
    private boolean is_kbm_request_with_error;
}
