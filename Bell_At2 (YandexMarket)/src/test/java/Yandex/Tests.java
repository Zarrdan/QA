package Yandex;

import Pages.MarketPage;
import Properties.TestData;
import Steps.StepsAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static Steps.StepsAll.*;

public class Tests extends BaseTest {

    @ParameterizedTest
    @MethodSource("Helpers.DataProvider#provideCheckingArguments")
    public void testYandexMarket(String name, String category, String subCategory,
                                 String minPrice, String maxPrice, String manufacturer1,
                                 String manufacturer2) {
        openSite(TestData.propsUrl.baseURLYandex(), chromeDriver);
        searchInYandex(name);
        goSiteByLink(name);
        goCategory(category);
        goSubCategory(subCategory);
        setPrice(minPrice, maxPrice);
        selectManufacturer(manufacturer1, manufacturer2);
        waitPage();
        setPage12Element();
        MarketPage marketPage = new MarketPage(chromeDriver);
        StepsAssert.checkResult12(chromeDriver, marketPage);
        saveFirstElement(marketPage);
        enterSaveFirstElement();
        StepsAssert.checkFinishResult(chromeDriver);
    }
}

