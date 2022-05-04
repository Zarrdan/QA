package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Стрим аргументов для теста
 */
public class DataProvider {
    public static Stream<Arguments> provideCheckingArguments(){
        return Stream.of(
                Arguments.of("Маркет", "Электроника", "Смартфоны", "Apple", "iPhone", 48)
        );
    }
}
