package Steps;

import Helpers.Screenshoter;
import Pages.MarketPage;
import Pages.MarketPageAfter;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static Steps.StepsAll.one;

public class StepsAssert {
    /**
     * Метод для проверки количества результатов на странице = 12, первым действие делется скриншот текущей страницы,
     * затем проверяется условие, что размер текущей страницы равен 12 элементам
     *
     * @param driver
     * @param marketPage
     */
    @Step("Проверка количество элементов на странице = 12 ")
    public static void checkResult12(WebDriver driver, MarketPage marketPage) {
        Screenshoter.getScreen(driver, marketPage.getExchangeRates());
        Assertions.assertEquals(12, new MarketPage(driver).getResults().size());
    }


    /**
     * Метод проверяет равны ли две строки, первая строчка приходит из функции saveFirstElement
     * вторая строчка получается в текущем методе.
     * Затем делается скриншот полученной вэбстраницы
     *
     * @param driver
     */
    @Step("Проверка на совпадение запомненного элемента и первого элемента в списке")
    public static void checkFinishResult(WebDriver driver) {
        MarketPageAfter marketpageafter = new MarketPageAfter(driver);
        Assertions.assertTrue(marketpageafter.getResultsFromMarket().get(0).getText().equals(one));
        Screenshoter.getScreen(driver);
    }
}
