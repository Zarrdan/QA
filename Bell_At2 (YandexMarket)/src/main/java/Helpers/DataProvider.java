package Helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Стрим аргументов для теста
 */
public class DataProvider {
    public static Stream<Arguments> provideCheckingArguments(){
        return Stream.of(
                Arguments.of("Маркет", "Компьютеры", "Ноутбуки", "10000", "90000", "HP", "Lenovo")
        );
    }
}
