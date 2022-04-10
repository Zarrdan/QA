package ru.chrome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver chromedriver;

    @BeforeEach
    public void before(){
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        chromedriver = new ChromeDriver();
        chromedriver.manage().window().maximize();
        chromedriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        chromedriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        chromedriver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

    }

    @AfterEach
    public void closeTest(){
       // chromedriver.quit();
    }


}
