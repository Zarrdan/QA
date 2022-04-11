package ru.chrome;


import org.junit.jupiter.api.Assertions;

import pages.*;


import java.util.List;


public class Test extends BaseTest {


    @org.junit.jupiter.api.Test
    public void testChrome() {
        chromedriver.get("https://google.ru/");
        GooglePage search = new GooglePage(chromedriver);
        search.search("Гладиолус");
        search.getResult().forEach(x -> System.out.println(x.getText()));
        Assertions.assertTrue(search.getResult().stream().anyMatch(x -> x.getText().contains("wikipedia")), "Сайта wikipedia не найдено");
    }


    @org.junit.jupiter.api.Test
    public void TestYandex1() {
        chromedriver.get("https://yandex.ru/");
        YandexBeforeSearch yandexBeforeSearch = new YandexBeforeSearch(chromedriver);
        yandexBeforeSearch.search("Открытие");
        YandexAfterSearch yandexAfterSearch = new YandexAfterSearch(chromedriver);

        Assertions.assertEquals(yandexAfterSearch.getResult().stream().anyMatch(p -> {
            if (p.getText().contains("Частным клиентам | Банк Открытие")) {
                yandexAfterSearch.openResult(p);

                for (String winHandle : chromedriver.getWindowHandles()) {
                    chromedriver.switchTo().window(winHandle);
                    System.out.println(winHandle);
                }
                List<String> collectExchangeRates = yandexAfterSearch.getResult1();
                int val = 0;
                val = collectExchangeRates.get(0).compareTo(collectExchangeRates.get(2));
                if (val < 0)
                    return true;
            }
            return false;
        }), true, " Частным клиентам | Банк Открытие не найдено");
    }

    @org.junit.jupiter.api.Test
    public void TestYandex2() {
        chromedriver.get("https://yandex.ru/");
        Yandex2BeforeSearch yandex2BeforeSearch = new Yandex2BeforeSearch(chromedriver);
        yandex2BeforeSearch.search("Таблица");
        Yandex2AfterSearch yandexAfterSearch = new Yandex2AfterSearch(chromedriver);


        Assertions.assertEquals(yandexAfterSearch.getResult().stream().anyMatch(p -> {
            if (p.getText().contains("Таблица — Википедия")) {
                yandexAfterSearch.openResult(p);

                for (String winHandle : chromedriver.getWindowHandles()) {
                    chromedriver.switchTo().window(winHandle);
                    // System.out.println(winHandle);
                }
                List<String> collectExchangeRates = yandexAfterSearch.getResult1();
                System.out.println( " 1 в таблице "+ collectExchangeRates.get(1));
                System.out.println("Последний в таблице " + collectExchangeRates.get(6));

                return true;
            }
            return false;
        }), true, "Таблица — Википедия не найдена");
    }

}