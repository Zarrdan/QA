package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GooglePage {

    protected WebDriver webDriver;
    protected WebElement searchField;
    protected WebElement searchButton;



    public GooglePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        searchField = webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchButton = webDriver.findElement(By.xpath("//input[@class='gNO89b']"));


    }

    public void search(String word) {
        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();
    }

    public List<WebElement> getResult() {
        return webDriver.findElements(By.xpath("//*[contains(@class, 'iUh30 qLRx3b tjvcx')]"));
    }

}
