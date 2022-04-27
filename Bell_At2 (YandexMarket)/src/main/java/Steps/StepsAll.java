package Steps;

import Helpers.Screenshoter;
import Pages.MarketPage;
import Pages.MarketPageAfter;
import Pages.YandexAfterSearch;
import Pages.YandexBeforeSearch;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsAll {
    private static WebDriverWait wait;
    private static WebDriver driver;
    protected static String one;

    /**
     * �� ������ ���� ��������� �������� ��������, ������ �� url �������� � �������� �����
     *
     * @param url
     * @param currentDriver
     */
    @Step("��������� �� ����: {url}")
    public static void openSite(String url, WebDriver currentDriver) {
        driver = currentDriver;
        driver.get(url);
        wait = new WebDriverWait(driver, 30);
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ���������� ����� �� ��������, �������� ������ ���������� �� class DataProvider
     *
     * @param searchQuery
     */
    @Step("���� � ���������� ������� �� �������� �����: {searchQuery}")
    public static void searchInYandex(String searchQuery) {
        YandexBeforeSearch yandexBeforeSearch = new YandexBeforeSearch(driver);
        yandexBeforeSearch.find(searchQuery);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-label='���������� ������']")));
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ���������� ������� �� ����� ��� �������� �� ���������, �������� ���������� �� class DataProvider
     *
     * @param title
     */
    @Step("��������� �� ���� �� ���������: {title}")
    public static void goSiteByLink(String title) {
        YandexAfterSearch yandexAfterSearch = new YandexAfterSearch(driver);
        yandexAfterSearch.goPageByLinkName(title);
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ���������� ����� ���������, �������� ���������� �� class DataProvider
     *
     * @param title
     */
    @Step("������� � ���������: {title}")
    public static void goCategory(String title) {
        MarketPage marketPage = new MarketPage(driver);
        marketPage.selectCategory(title);
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ���������� ����� ������������, �������� ���������� �� class DataProvider
     *
     * @param title
     */
    @Step("������� ��������� {title}")
    public static void goSubCategory(String title) {
        new MarketPage(driver).selectSubCategory(title);
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ���������� ����� ����������� � ������������ ����, �������� ���������� �� class DataProvider
     *
     * @param minPrice
     * @param maxPrice
     */
    @Step("������ �������� ���� �� {minPrice} �� {maxPrice} ������.")
    public static void setPrice(String minPrice, String maxPrice) {
        new MarketPage(driver).setPrice(minPrice, maxPrice);
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ������������ ����� ��������������, �������� ���������� �� class DataProvider
     *
     * @param manufacturerName1
     */
    @Step("������� ������������� {manufacturerName1}")
    public static void selectManufacturer1(String manufacturerName1) {
        new MarketPage(driver).setManufacture1(manufacturerName1);
        Screenshoter.getScreen(driver);
    }

    /**
     * �� ������ ���� ���������� �������� ��������� �������, ����� �������� ���� ��������
     */
    @Step("�������� �������� ��������")
    public static void waitPage() {
        new MarketPage(driver).waitResult();
    }

    /**
     * �� ������ ���� ���������� ����� ������ 12 ��������� �� ��������
     */
    @Step("����� 12 ��������� �� ��������")
    public static void setPageElement(String set) {
        new MarketPage(driver).setPageByElement(set);
    }

    /**
     * �� ������ ���� ���������� ������������ ������� �������� �� ��������
     *
     * @param marketPage
     */
    @Step("����������� ������� �������� �� ��������")
    public static void saveFirstElement(MarketPage marketPage) {
        marketPage.setFirstElementInList(marketPage.getResults().get(0));
        one = marketPage.getFirstElementInList().getText();
        Screenshoter.getScreen(driver, marketPage.getResultsScreen());
    }

    /**
     * �� ������ ���� ����������� ������� �������� � ������ ������ �� ��������
     */
    @Step("����� ������������ �������� �� ������ �������")
    public static void enterSaveFirstElement() {
        MarketPageAfter marketpageafter = new MarketPageAfter(driver);
        marketpageafter.findFirstElement(one);
        Screenshoter.getScreen(driver);
    }
}
