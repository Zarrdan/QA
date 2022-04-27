package Helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Стрим аргументов для теста
 */
public class DataProvider {
    public static Stream<Arguments> provideCheckingArguments(){
        List<String> manufacturer = new ArrayList<>();
        manufacturer.add("HP");
        manufacturer.add("Lenovo");
        manufacturer.add("DELL");
        return Stream.of(
                Arguments.of("Маркет", "Компьютеры", "Ноутбуки", "10000", "90000", manufacturer, "12")
        );
    }
}
