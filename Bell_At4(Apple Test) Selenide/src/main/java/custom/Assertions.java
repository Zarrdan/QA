package custom;

import io.qameta.allure.Step;

public class Assertions {

    @Step("Проверяю на содержание: '{message}'")
    public static void assertTrue(boolean condition, String message) {
        org.junit.jupiter.api.Assertions.assertTrue(condition, message);
    }

    @Step("Проверяю на количество элементов на странице: '{message}'")
    public static void assertTrueCount(int expected, int actual, String message) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual, message);
    }
}
