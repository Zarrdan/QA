package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MarketPageAfter {
    private WebElement inputSearch;
    private WebElement buttonSearch;
    private WebDriver webDriver;
    WebDriverWait wait;
    private List<WebElement> results;

    /**
     * Конструктор страницы, получает на вход вэбдрайвер, так же создает локаторы на готовность
     * получения информации для поиска на сайте
     * @param webDriver
     */
    public MarketPageAfter(WebDriver webDriver){
        wait = new WebDriverWait(webDriver,120);
        this.webDriver = webDriver;
        this.inputSearch = webDriver.findElement(By.id("header-search"));
        this.buttonSearch = webDriver.findElement(By.xpath("//button[span[text()='Найти']]"));
    }

    /**
     * Данный метод получает аргумент в виде строки, и производит поиск на сайте
     * @param text
     */
    public void findFirstElement(String text){
        inputSearch.sendKeys(text);
        buttonSearch.click();
    }

    /**
     * Получение листа в виде вэбэлемента
     * @return
     */
    public List<WebElement> getResultsFromMarket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-zone-name='title'][contains(text(), '')]")));
        results = webDriver.findElements(By.xpath("//*[@data-zone-name='title'][contains(text(), '')]"));
        return results;
    }
}
