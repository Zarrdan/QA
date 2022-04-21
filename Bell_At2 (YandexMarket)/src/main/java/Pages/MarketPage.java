package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class MarketPage {

    private WebDriver webDriver;
    private WebElement inputSearch;
    private WebElement firstElementInList;
    private WebDriverWait wait;
    private WebElement exchangeRates;

    /**
     * Конструктор страницы, примает вэбдрайвер, создает переменную вэит для получения ожиданий в дальнейшем
     *
     * @param webDriver
     */
    public MarketPage(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, 120);
        this.webDriver = webDriver;
    }

    /**
     * Метод выбора категории, получает на вход название категории,затем кликает по данной категории
     *
     * @param title
     */
    public void selectCategory(String title) {
        webDriver.findElement(By.xpath("//*[contains(@class, '_10dWC')]")).click();
        this.inputSearch = webDriver.findElement(By.xpath("//*[contains(text(), '" + title + "')]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(inputSearch).build().perform();

    }

    /**
     * Метод выбора подкатегории, получает на вход название субкатегории, затем переходит на данную субкатегорию
     *
     * @param title
     */
    public void selectSubCategory(String title) {
        webDriver.findElement(By.xpath("//*[contains(@class, 'egKyN _1mqvV _3kgUl')][contains(text(), '" + title + "')]")).click();
    }

    /**
     * Метод ввода миниальной и максимальной цены для товара
     *
     * @param minPrice
     * @param maxPrice
     */
    public void setPrice(String minPrice, String maxPrice) {
        webDriver.findElement(By.xpath("//input[@name='Цена от']")).sendKeys(minPrice);
        webDriver.findElement(By.xpath("//input[@name='Цена до']")).sendKeys(maxPrice);

    }

    /**
     * Метод для ввода торговой марки
     *
     * @param manufacture1
     * @param manufacture2
     */
    public void setManufacture(String manufacture1, String manufacture2) {
        webDriver.findElement(By.xpath("//*[@class= '_1o8_r xUzR2'] [contains(text(), '" + manufacture1 + "')]")).click();
        webDriver.findElement(By.xpath("//*[@class= '_1o8_r xUzR2'] [contains(text(), '" + manufacture2 + "')]")).click();

    }

    /**
     * Метод для прогрузки страницы, после выбора всех условий поиска
     */
    public void waitResult() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, '_2Lvbi _1oZmP')]")));
    }

    /**
     * Метод для выбора количества показов товаров на странице по 12 штук.
     */
    public void setPageBy12Element() {
        webDriver.findElement(By.xpath("//*[contains(@class, 'vLDMf')]")).click();
        webDriver.findElement(By.xpath("//*[contains(@class, '_1KpjX _35Paz')][contains(text(), 'Показывать по 12')]")).click();
        Set<String> tabs = webDriver.getWindowHandles();
        for (String tab : tabs)
            webDriver.switchTo().window(tab);

    }

    /**
     * Метод для получения вэбэлемента, нужен для создания скриншота внизу страницы ( где показывает количество элементов 12 штук)
     *
     * @return
     */
    public WebElement getExchangeRates() {
        exchangeRates = webDriver.findElement(By.xpath("//*[contains(@class, '_2G3_d')]"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, '_2Lvbi _1oZmP')]")));
        return exchangeRates;

    }


    /**
     * Метод для получения результат вэбстраницы
     *
     * @return
     */
    public List<WebElement> getResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, '_2UHry _2vVOc')]")));
        return webDriver.findElements(By.xpath("//*[contains(@class, '_2UHry _2vVOc')]"));
    }

    /**
     * Метод для получения скриншота, в определенном месте вэб страницы
     *
     * @return
     */
    public WebElement getResultsScreen() {
        exchangeRates = webDriver.findElement(By.xpath("//*[contains(@class, '_2UHry _2vVOc')]"));
        return exchangeRates;
    }

    /**
     * Метод для установки, первого элемента на вэбстранице
     *
     * @param firstElementInList
     */
    public void setFirstElementInList(WebElement firstElementInList) {
        this.firstElementInList = firstElementInList;
    }

    /**
     * Получение первого элемента вэбстраницы
     *
     * @return
     */
    public WebElement getFirstElementInList() {
        return firstElementInList;
    }
}
