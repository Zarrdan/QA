package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class DriverAnswer {
    private String id;
    private String fact_address;
    private String legal_address;
    private List<Contact> contact;
    @JsonProperty("driver_licenses")
    private List<DriverLicenseAnswer> DriverLicenseListAnswer;
    private String first_name;
    private String last_name;
    private String patronymic;
    private String previous_last_name;
    private String birth_date;
    private String gender;
    private String driving_experience_started;
    private String is_rsa_checked;
    private String is_kbm_found;
    private String kbm_value;
    private String previous_policy_serial;
    private String previous_policy_number;
}
