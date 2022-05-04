package pagesnew;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class YandexBasePage {

    /**
     * Данный метод переходит на главную страницу яндекса
     * @param url
     * @param pageObjectClass
     * @return
     * @param <T>
     */
    @Step("Зайти на {url}")
    public static <T extends YandexBasePage> T openUrl(String url, Class<T> pageObjectClass) {
        open(url, pageObjectClass);
        return pageObjectClass.cast(page(pageObjectClass));
    }
}
