package Assertions;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class NewAsserts {
    @Step("Проверяю, что: '{message}'")
    public static void assertEquals(List<String> list, Set<String> set, String message) {
        Assert.assertEquals(list, set, message);
    }

    @Step("Проверяю, что: '{message}'")
    public static void assertEqualsYear(List<Integer> actual, List<Integer> sort, String message) {
        Assert.assertEquals(actual, sort, message);
    }

    @Step("Проверяю, что: '{message}'")
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step("Проверяю, что: '{message}'")
    public static void assertEqualsSize(int actual, int expected,  String message) {
        Assert.assertEquals(actual,expected, message);
    }
}
