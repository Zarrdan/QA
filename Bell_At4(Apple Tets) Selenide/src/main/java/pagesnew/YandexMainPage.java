package pagesnew;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexMainPage extends YandexBasePage {


    /**
     * Данный метод переходит в яндекс маркет, на главной странице яндекса
     * @param linkName
     * @return
     */
    @Step("Перейти в Яндекс.{linkName}")
    public YandexMarketMainPage goLinkByName(String linkName) {
        ElementsCollection resultSearch = $$x("//div[@class='services-new__item-title']");
        resultSearch.find(exactText(linkName)).click();
        switchTo().window(1);
        return page(YandexMarketMainPage.class);
    }
}
