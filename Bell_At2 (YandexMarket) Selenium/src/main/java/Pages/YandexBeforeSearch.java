package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexBeforeSearch {
    private WebElement inputSearch;
    private WebElement buttonSearch;
    private WebDriver webDriver;
    /**
     * Страница для первоначального поиска на яндекс, сюда приходит запрос и нажимается поиск
     */
    public YandexBeforeSearch(WebDriver webDriver){
        this.webDriver = webDriver;
        this.inputSearch = webDriver.findElement(By.xpath("//input[@aria-label='Запрос']"));
        this.buttonSearch = webDriver.findElement(By.xpath("//button[span[text()='Найти']]"));
    }

    public void find(String text){
        inputSearch.sendKeys(text);
        buttonSearch.click();
    }
}
