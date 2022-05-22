package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Car {
    private String id;
    ArrayList<Object> credential = new ArrayList<>();
    private String car_mark;
    private String car_mark_id;
    private String car_type;
    private String car_model;
    private String car_model_id;
    private String rsa_code;
    private float manufacturing_year;
    private String vin_number;
    private String car_body_number;
    private String chassis_number;
    private String car_modification;
    private String car_modification_id;
    private String transdekra_id;
    private String transdekra_modification;
    private String number_plate;
    private boolean has_trailer;
    @JsonProperty("is_foreign")
    private boolean is_foreign;
    private String color;
    private String engine_displacement;
    private float engine_power;
    private String pts_mark;
    private String pts_model;
    private String max_mass;
    private String seats_count;
    @JsonProperty("is_rsa_checked")
    private boolean is_rsa_checked;
    @JsonProperty("is_deprecated")
    private boolean is_deprecated;
}
