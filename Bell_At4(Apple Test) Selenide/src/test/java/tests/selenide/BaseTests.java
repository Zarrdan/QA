package tests.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import custom.allure.selenide.CustomAllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTests {

    @BeforeAll
    public static void screenShot() {
        SelenideLogger.addListener("Allureselenide", new CustomAllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeEach
    public void option() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1600x900";
       // Configuration.holdBrowserOpen = true;
        Configuration.timeout = 15000;
    }
}
