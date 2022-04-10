package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexBeforeSearch {
    protected WebDriver webDriver;
    protected WebElement searchField;
    protected WebElement searchButton;

    public YandexBeforeSearch(WebDriver webDriver) {
        this.webDriver = webDriver;
        searchField = webDriver.findElement(By.xpath("//input[@name='text']"));
        searchButton = webDriver.findElement(By.xpath("//*[text()='Найти']/.."));
    }

    public void search(String word) {
        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();
    }
}
