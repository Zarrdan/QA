package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ResourceInfo {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    @JsonProperty("data")
    private List<ResourceInfoData> userDataResponseList;
    private Support support;
}

