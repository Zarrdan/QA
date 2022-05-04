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
     * ����� ��� �������� ���������� ����������� �� �������� = 12, ������ �������� ������� �������� ������� ��������,
     * ����� ����������� �������, ��� ������ ������� �������� ����� 12 ���������
     *
     * @param driver
     * @param marketPage
     */
    @Step("�������� ���������� ��������� �� �������� = 12 ")
    public static void checkResult12(WebDriver driver, MarketPage marketPage) {
        Screenshoter.getScreen(driver, marketPage.getExchangeRates());
        Assertions.assertEquals(12, new MarketPage(driver).getResults().size());
    }


    /**
     * ����� ��������� ����� �� ��� ������, ������ ������� �������� �� ������� saveFirstElement
     * ������ ������� ���������� � ������� ������.
     * ����� �������� �������� ���������� �����������
     *
     * @param driver
     */
    @Step("�������� �� ���������� ������������ �������� � ������� �������� � ������")
    public static void checkFinishResult(WebDriver driver) {
        MarketPageAfter marketpageafter = new MarketPageAfter(driver);
        Assertions.assertTrue(marketpageafter.getResultsFromMarket().get(0).getText().equals(one));
        Screenshoter.getScreen(driver);
    }
}
