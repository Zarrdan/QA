package tests.selenide;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pagesnew.YandexBasePage;
import pagesnew.YandexMainPage;
import propetties.TestData;

public class Tests extends BaseTests {

    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideCheckingArguments")
    public void testYandexMarket(String name, String category, String subCategory,
                                 String manufacturer, String contains, int actualPageSize) {
        YandexBasePage.openUrl(TestData.propsUrl.baseURLYandex(), YandexMainPage.class)
                .goLinkByName(name)
                .selectCategory(category)
                .selectSubCategory(subCategory)
                .selectManufacturer(manufacturer)
                .checkElementPage(actualPageSize)
                .checksSearchResultsNames(contains);
    }
}
