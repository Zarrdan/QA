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
        //*[contains(@class, '_10dWC')]
        webDriver.findElement(By.xpath("//*[@id='catalogPopupButton']")).click();
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
     */
    public void setManufacture1(String manufacture1) {
        webDriver.findElement(By.xpath("//fieldset[@data-autotest-id='7893318']//*[contains(text(), '" + manufacture1 + "')]")).click();
        waitResult();
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
    public void setPageByElement(String set) {
        webDriver.findElement(By.xpath(" //*[contains(@class, 'vLDMf')]")).click();
        webDriver.findElement(By.xpath(" //button[contains(text(),'���������� �� " + set + "')]")).click();
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
        waitResult();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, '_2Lvbi _1oZmP')]")));
        return exchangeRates;

    }


    /**
     * ����� ��� ��������� ��������� �����������
     *
     * @return
     */
    public List<WebElement> getResults() {
        //*[contains(@class, '_2UHry _2vVOc')]
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@data-zone-name='title'][contains(text(), '')]")));
        return webDriver.findElements(By.xpath("//*[@data-zone-name='title'][contains(text(), '')]"));
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
