package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Стрим аргументов для теста
 */
public class DataProvider {
    public static Stream<Arguments> provideCheckingArguments() {
        return Stream.of(
                Arguments.of("/api/users?page=2")
        );
    }

    public static Stream<Arguments> provideCheckingSucsessAuth() {
        return Stream.of(
                Arguments.of("/api/login", "eve.holt@reqres.in", "pistol")
        );
    }

    public static Stream<Arguments> provideCheckingUnSucsessAuth() {
        return Stream.of(
                Arguments.of("/api/login", "peter@klaven")
        );
    }

    public static Stream<Arguments> provideCheckingCountTag() {
        return Stream.of(
                Arguments.of("https://gateway.autodns.com/", 14)
        );
    }

    public static Stream<Arguments> provideCheckingSortYears() {
        return Stream.of(
                Arguments.of("/api/unknown")
        );
    }
}
