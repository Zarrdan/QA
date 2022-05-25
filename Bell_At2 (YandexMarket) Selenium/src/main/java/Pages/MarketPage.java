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
        //*[contains(@class, '_10dWC')]
        webDriver.findElement(By.xpath("//*[@id='catalogPopupButton']")).click();
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
        //*[contains(@class, 'egKyN _1mqvV _3kgUl')]
        List<WebElement> tableHeaders = webDriver.findElements(By.xpath("//div[@data-zone-name='link']//*[contains(text(), '" + title + "')]"));
        for (int i = 0; i < tableHeaders.size(); i++){
            String text = tableHeaders.get(i).getText();
          //  System.out.println(text);
            boolean flag = text.equals(title);
            if (flag == true)
                tableHeaders.get(i).click();
        }
    }

    /**
     * Метод ввода миниальной и максимальной цены для товара
     *
     * @param minPrice
     * @param maxPrice
     */
    public void setPrice(String minPrice, String maxPrice) {
        webDriver.findElement(By.xpath("//input[@name='Öåíà îò']")).sendKeys(minPrice);
        webDriver.findElement(By.xpath("//input[@name='Öåíà äî']")).sendKeys(maxPrice);
    }

     /**
     * Метод для ввода торговой марки
     *
     * @param manufacture1
     */
    public void setManufacture1(String manufacture1) {
        webDriver.findElement(By.xpath("//fieldset[@data-autotest-id='7893318']//*[contains(text(), '" + manufacture1 + "')]")).click();
        waitResult();
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
    public void setPageByElement(String set) {
        webDriver.findElement(By.xpath(" //*[contains(@class, 'vLDMf')]")).click();
        webDriver.findElement(By.xpath(" //button[contains(text(),'Ïîêàçûâàòü ïî " + set + "')]")).click();
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
        waitResult();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, '_2Lvbi _1oZmP')]")));
        return exchangeRates;

    }


  /**
     * Метод для получения результат вэбстраницы
     *
     * @return
     */
    public List<WebElement> getResults() {
        //*[contains(@class, '_2UHry _2vVOc')]
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@data-zone-name='title'][contains(text(), '')]")));
        return webDriver.findElements(By.xpath("//*[@data-zone-name='title'][contains(text(), '')]"));
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
