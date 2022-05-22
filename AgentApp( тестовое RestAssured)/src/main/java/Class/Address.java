package Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Address {
    @JsonProperty("data")
    Data data;
    private String address_query;
    private String address_type;
    private String region_kladr_id;
    private String city_kladr_id;
    private String settlement_kladr_id;
    private String street_kladr_id;
    private String house_kladr_id;
    private String is_without_flat;
    private String house;
    private String block;
    private String flat;
    private String region_fias_id;
    private String city_fias_id;
    private String settlement_fias_id;
    private String street_fias_id;
}
