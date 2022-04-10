package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Yandex2AfterSearch extends Yandex2BeforeSearch {


    private List<String> collectExchangeRates = new ArrayList<>();

    public Yandex2AfterSearch(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getResult() {
        return webDriver.findElements(By.xpath("//*[contains(@class, 'OrganicTitle-LinkText Typo Typo_text_l Typo_line_m organic__url-text')]"));
    }

    public void openResult(WebElement webElement) {
        webElement.click();
    }

    public List<String> getResult1(){
        //*[contains(text(), 'Преподаватели кафедры программирования')]
        List<WebElement> tableHeaders = webDriver.findElements(By.xpath("//table[@class='wikitable']/tbody/tr"));
        for(int i= 0; i<tableHeaders.size();++i){
            List<String> collectRow = new ArrayList<>();
            for (int j=0;j<tableHeaders.size();++j){
                collectRow.add(
                        tableHeaders.get(j).getText());
            }
            return collectRow;
           // collectExchangeRates.add(String.valueOf(collectRow));
        }
        return collectExchangeRates;
    }

}
