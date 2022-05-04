package pagesnew;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import custom.Assertions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPages {

    private ElementsCollection info = $$x("//*[contains(@data-zone-name, 'title')]");

    /**
     * Данный метод выбирает проивзодителя товара и кликает на него
     *
     * @param title
     * @return
     */
    @Step("Выбрать производителя {title}")
    public CatalogPages selectManufacturer(String title) {
        SelenideElement manufacturer = $x("//*[contains(text(), 'Показать всё')]");
        manufacturer.click();
        SelenideElement click = $x("//*[@data-grabber='SearchFilters']//*[contains(text(), '" + title + "')]");
        click.click();
        waitsSearchResult();
        return page(CatalogPages.class);
    }

    /**
     * Данный метод ожидает результаты загрузки страницы
     *
     * @return
     */
    @Step("Дождаться результатов поиска.")
    public CatalogPages waitsSearchResult() {
        SelenideElement wait = $x("//*[@aria-label='Загрузка...']");
        wait.should(disappear);
        return page(CatalogPages.class);
    }


    /**
     * Данный метод проверяет количество элементов на странице
     *
     * @param actualPageSize
     * @return
     */
    @Step("Проверка количества элементов на странице")
    public CatalogPages checkElementPage(int actualPageSize) {
        SelenideElement buttonMore = $x("//*[contains(@data-auto, 'pager-more')]");
        buttonMore.scrollTo();
        info = $$x("//*[contains(@data-zone-name, 'title')]");
        Assertions.assertTrueCount(info.size(), actualPageSize, " 48 элементов");
        return page(CatalogPages.class);
    }

    /**
     * Данный метод переходит по всем страницам яндекс маркета (максимальное ограничение в 50 страниц),
     * затем проверяет на соответствие текущего результата и ожидаемое слово в поисковой выдаче
     *
     * @param contains
     * @return
     */
    @Step("Убедиться что в выборку попали только {contains}. Если страниц несколько – проверить все.")
    public CatalogPages checksSearchResultsNames(String contains) {
        SelenideElement buttonMore = $x("//*[contains(@data-auto, 'pager-more')]");
        int countPage = 0;
        while (buttonMore.is(exist) && countPage++ <= 50) {
            waitsSearchResult();
            if (buttonMore.is(disappear))
                break;
            if (buttonMore.is(exist))
                buttonMore.click();
        }
        for (int i = 0; i < info.size(); i++) {
            String text = info.get(i).text();
            info.get(i).scrollTo();
            boolean flag = text.contains(contains);
            if (!flag)
                System.out.println(info.get(i).getText());
            Assertions.assertTrue(flag, contains);
        }
        return page(CatalogPages.class);
    }
}

