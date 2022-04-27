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
     * ����������� ��������, �������� �� ���� ����������, ��� �� ������� �������� �� ����������
     * ��������� ���������� ��� ������ �� �����
     * @param webDriver
     */
    public MarketPageAfter(WebDriver webDriver){
        wait = new WebDriverWait(webDriver,120);
        this.webDriver = webDriver;
        this.inputSearch = webDriver.findElement(By.id("header-search"));
        this.buttonSearch = webDriver.findElement(By.xpath("//button[span[text()='�����']]"));
    }

    /**
     * ������ ����� �������� �������� � ���� ������, � ���������� ����� �� �����
     * @param text
     */
    public void findFirstElement(String text){
        inputSearch.sendKeys(text);
        buttonSearch.click();
    }

    /**
     * ��������� ����� � ���� �����������
     * @return
     */
    public List<WebElement> getResultsFromMarket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-zone-name='title'][contains(text(), '')]")));
        results = webDriver.findElements(By.xpath("//*[@data-zone-name='title'][contains(text(), '')]"));
        return results;
    }
}
