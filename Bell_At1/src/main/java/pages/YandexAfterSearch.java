package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class YandexAfterSearch extends YandexBeforeSearch {

    private List<String> collectExchangeRates = new ArrayList<>();

    public YandexAfterSearch(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getResult() {
        return webDriver.findElements(By.xpath("//*[contains(@class, 'OrganicTitle-LinkText Typo Typo_text_l Typo_line_m organic__url-text')]"));
    }

    public void openResult(WebElement webElement) {
        webElement.click();
    }

    public List<String> getResult1(){
        List<WebElement> tableHeaders = webDriver.findElements(By.xpath("//*[contains(@class, 'main-page-exchange__rate')]"));
        for(int i= 0; i<tableHeaders.size();++i){
            List<String> collectRow =new ArrayList<>();
            for (int j=0;j<tableHeaders.size();++j){
                collectRow.add(
                        tableHeaders.get(j).getText());
            }
            return collectRow;
        }
        return collectExchangeRates;
    }
}
