package Class;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class InsuranceObject {
    private String id;
    ArrayList<String> drivers = new ArrayList<>();
    private String car;
    private String owner;
    private String insurant;

    public static class Calculation {
    }
}
