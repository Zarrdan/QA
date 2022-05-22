package Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Insurance {
    List<String> drivers = new ArrayList<>();
    private String owner;
    private String car;
    private String insurant;

}
