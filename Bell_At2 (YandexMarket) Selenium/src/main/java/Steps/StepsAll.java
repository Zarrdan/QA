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
     * На данном шаге происхдит открытие страницы, ссылка на url приходит с проперти файла
     *
     * @param url
     * @param currentDriver
     */
    @Step("Переходим на сайт: {url}")
    public static void openSite(String url, WebDriver currentDriver) {
        driver = currentDriver;
        driver.get(url);
        wait = new WebDriverWait(driver, 30);
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге происходит поиск на странице, параметр поиска передается из class DataProvider
     *
     * @param searchQuery
     */
    @Step("Ищем в поисковике яндекса по ключевой фразе: {searchQuery}")
    public static void searchInYandex(String searchQuery) {
        YandexBeforeSearch yandexBeforeSearch = new YandexBeforeSearch(driver);
        yandexBeforeSearch.find(searchQuery);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Результаты поиска']")));
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге происходит переход на новую вэб страницу по заголовку, параметр передается из class DataProvider
     *
     * @param title
     */
    @Step("Переходим на сайт по заголовку: {title}")
    public static void goSiteByLink(String title) {
        YandexAfterSearch yandexAfterSearch = new YandexAfterSearch(driver);
        yandexAfterSearch.goPageByLinkName(title);
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге происходит выбор категории, параметр передается из class DataProvider
     *
     * @param title
     */
    @Step("Переход в категорию: {title}")
    public static void goCategory(String title) {
        MarketPage marketPage = new MarketPage(driver);
        marketPage.selectCategory(title);
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге происходит выбор субкатегории, параметр передается из class DataProvider
     *
     * @param title
     */
    @Step("Выбрать подраздел {title}")
    public static void goSubCategory(String title) {
        new MarketPage(driver).selectSubCategory(title);
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге происходит выбор минимальной и максимальной цены, параметр передается из class DataProvider
     *
     * @param minPrice
     * @param maxPrice
     */
    @Step("Задать параметр Цена от {minPrice} до {maxPrice} рублей.")
    public static void setPrice(String minPrice, String maxPrice) {
        new MarketPage(driver).setPrice(minPrice, maxPrice);
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге производится выбор проивзодителей, параметр передается из class DataProvider
     *
     * @param manufacturerName1
     */
    @Step("Выбрать производителя {manufacturerName1}")
    public static void selectManufacturer1(String manufacturerName1) {
        new MarketPage(driver).setManufacture1(manufacturerName1);
        Screenshoter.getScreen(driver);
    }

    /**
     * На данном шаге происходит ожидание прогрузки станицы, после внесения всех фильтров
     */
    @Step("Ожидание загрузки страницы")
    public static void waitPage() {
        new MarketPage(driver).waitResult();
    }

    /**
     * На данном шаге происходит выбор показа 12 элементов на странице
     */
    @Step("Выбор 12 элементов на странице")
    public static void setPageElement(String set) {
        new MarketPage(driver).setPageByElement(set);
    }

    /**
     * На данном шаге происходит запоминманеи первого элемента на странице
     *
     * @param marketPage
     */
    @Step("Запоминание первого элемента на странице")
    public static void saveFirstElement(MarketPage marketPage) {
        marketPage.setFirstElementInList(marketPage.getResults().get(0));
        one = marketPage.getFirstElementInList().getText();
        Screenshoter.getScreen(driver, marketPage.getResultsScreen());
    }

    /**
     * На данном шаге запомненный элемент вводится в строку поиска на странице
     */
    @Step("Поиск запомненного элемента на яндекс маркете")
    public static void enterSaveFirstElement() {
        MarketPageAfter marketpageafter = new MarketPageAfter(driver);
        marketpageafter.findFirstElement(one);
        Screenshoter.getScreen(driver);
    }
}
