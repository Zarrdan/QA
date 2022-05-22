package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class AnswerInsurance {
    private String id;
    ArrayList<Object> credential = new ArrayList<>();
    ArrayList<Object> address = new ArrayList<>();
    private String person;
    @JsonProperty("fact_address")
    Fact_Address Fact_addressObject;
    @JsonProperty("legal_address")
    Legal_Address Legal_addressObject;
    ArrayList<Object> contact = new ArrayList<>();
    private String first_name;
    private String last_name;
    private String patronymic;
    private String previous_last_name;
    private String birth_date;
    private String gender;
    private String driving_experience_started;
    @JsonProperty("is_rsa_checked")
    private boolean is_rsa_checked;
    @JsonProperty("is_kbm_found")
    private boolean is_kbm_found;
    private String kbm_value;
    private String previous_policy_serial;
    private String previous_policy_number;
}
