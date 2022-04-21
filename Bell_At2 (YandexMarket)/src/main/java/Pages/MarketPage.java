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
     * ����������� ��������, ������� ����������, ������� ���������� ���� ��� ��������� �������� � ����������
     *
     * @param webDriver
     */
    public MarketPage(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, 120);
        this.webDriver = webDriver;
    }

    /**
     * ����� ������ ���������, �������� �� ���� �������� ���������,����� ������� �� ������ ���������
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
     * ����� ������ ������������, �������� �� ���� �������� ������������, ����� ��������� �� ������ ������������
     *
     * @param title
     */
    public void selectSubCategory(String title) {
        webDriver.findElement(By.xpath("//*[contains(@class, 'egKyN _1mqvV _3kgUl')][contains(text(), '" + title + "')]")).click();
    }

    /**
     * ����� ����� ���������� � ������������ ���� ��� ������
     *
     * @param minPrice
     * @param maxPrice
     */
    public void setPrice(String minPrice, String maxPrice) {
        webDriver.findElement(By.xpath("//input[@name='���� ��']")).sendKeys(minPrice);
        webDriver.findElement(By.xpath("//input[@name='���� ��']")).sendKeys(maxPrice);

    }

    /**
     * ����� ��� ����� �������� �����
     *
     * @param manufacture1
     * @param manufacture2
     */
    public void setManufacture(String manufacture1, String manufacture2) {
        webDriver.findElement(By.xpath("//*[@class= '_1o8_r xUzR2'] [contains(text(), '" + manufacture1 + "')]")).click();
        webDriver.findElement(By.xpath("//*[@class= '_1o8_r xUzR2'] [contains(text(), '" + manufacture2 + "')]")).click();

    }

    /**
     * ����� ��� ��������� ��������, ����� ������ ���� ������� ������
     */
    public void waitResult() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, '_2Lvbi _1oZmP')]")));
    }

    /**
     * ����� ��� ������ ���������� ������� ������� �� �������� �� 12 ����.
     */
    public void setPageBy12Element() {
        webDriver.findElement(By.xpath("//*[contains(@class, 'vLDMf')]")).click();
        webDriver.findElement(By.xpath("//*[contains(@class, '_1KpjX _35Paz')][contains(text(), '���������� �� 12')]")).click();
        Set<String> tabs = webDriver.getWindowHandles();
        for (String tab : tabs)
            webDriver.switchTo().window(tab);

    }

    /**
     * ����� ��� ��������� �����������, ����� ��� �������� ��������� ����� �������� ( ��� ���������� ���������� ��������� 12 ����)
     *
     * @return
     */
    public WebElement getExchangeRates() {
        exchangeRates = webDriver.findElement(By.xpath("//*[contains(@class, '_2G3_d')]"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, '_2Lvbi _1oZmP')]")));
        return exchangeRates;

    }


    /**
     * ����� ��� ��������� ��������� �����������
     *
     * @return
     */
    public List<WebElement> getResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, '_2UHry _2vVOc')]")));
        return webDriver.findElements(By.xpath("//*[contains(@class, '_2UHry _2vVOc')]"));
    }

    /**
     * ����� ��� ��������� ���������, � ������������ ����� ��� ��������
     *
     * @return
     */
    public WebElement getResultsScreen() {
        exchangeRates = webDriver.findElement(By.xpath("//*[contains(@class, '_2UHry _2vVOc')]"));
        return exchangeRates;
    }

    /**
     * ����� ��� ���������, ������� �������� �� �����������
     *
     * @param firstElementInList
     */
    public void setFirstElementInList(WebElement firstElementInList) {
        this.firstElementInList = firstElementInList;
    }

    /**
     * ��������� ������� �������� �����������
     *
     * @return
     */
    public WebElement getFirstElementInList() {
        return firstElementInList;
    }
}
