package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexBeforeSearch {
    private WebElement inputSearch;
    private WebElement buttonSearch;
    private WebDriver webDriver;
    /**
     * �������� ��� ��������������� ������ �� ������, ���� �������� ������ � ���������� �����
     */
    public YandexBeforeSearch(WebDriver webDriver){
        this.webDriver = webDriver;
        this.inputSearch = webDriver.findElement(By.xpath("//input[@aria-label='������']"));
        this.buttonSearch = webDriver.findElement(By.xpath("//button[span[text()='�����']]"));
    }

    public void find(String text){
        inputSearch.sendKeys(text);
        buttonSearch.click();
    }
}
