package pagesnew;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexMarketMainPage extends YandexBasePage {
    private SelenideElement click = $x(" //*[contains(@id, 'catalogPopupButton')]");
    private ElementsCollection categories = $$x("//li[@data-zone-name='category-link']/a/span");
    private ElementsCollection subcategories = $$x(" //div[@class='theme_light']//a");

    /**
     * Данный метод выбирает категорию товаров
     * @param title
     * @return
     */
    @Step("Выбрать категорию {title}")
    public YandexMarketMainPage selectCategory(String title) {
        click.click();
        categories.find(exactText(title)).hover();
        return this;
    }

    /**
     * Данный метод выбирает субкатегорию товаров
     * @param title
     * @return
     */
    @Step("Выбрать субкатегорию {title}")
    public CatalogPages selectSubCategory(String title) {
        subcategories.find(exactText(title)).click();
        return page(CatalogPages.class);

    }
}
