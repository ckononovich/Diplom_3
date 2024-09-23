package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseSetupWithoutUserCreation {
    WebDriver driver;

    @Before
    public void generalSetUp() {
        if ("yandex".equals(System.getProperty("driverType"))) {
            browserYandex(System.getProperty("pathYandexDriver"), System.getProperty("yandexBrowser"));
        } else {
            browserChrome();
        }
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    private void browserYandex(String pathYandexDriver, String yandexBrowser) {
        System.setProperty("webdriver.chrome.driver", pathYandexDriver);
        ChromeOptions options = new ChromeOptions().setBinary(yandexBrowser);
        driver = new ChromeDriver(options);
    }

    private void browserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    @Step("Close the window")
    public void quitTheWindow() {
        driver.quit();
    }
}