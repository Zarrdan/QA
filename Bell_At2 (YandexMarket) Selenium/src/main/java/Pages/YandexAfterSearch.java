package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class YandexAfterSearch {
    private WebDriver webDriver;

    /**
     * Конструктор страницы, получает вэбдрайвер
     * @param webDriver
     */
    public YandexAfterSearch(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Метод для перехода по запросу, запрос приходит в виде строки, так же происходит переход на новое окно для селениум.
     * @param link
     */
    public void goPageByLinkName(String link){
        webDriver.findElement(By.xpath("//li[@class='serp-item desktop-card']//a[contains(.,'"+link+"')]")).click();
        Set<String> tabs = webDriver.getWindowHandles();
        for(String tab:tabs)
            webDriver.switchTo().window(tab);
    }
}
