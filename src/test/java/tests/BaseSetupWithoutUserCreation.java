package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import model.DataForTests;
import model.Path;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseSetupWithoutUserCreation {
    DataForTests dataForTests = new DataForTests();
    Path path = new Path();

    WebDriver driver;

    @Before
    public void generalSetUp() {
        if ("yandex".equals(System.getProperty("yandex"))) {
            browserYandex();
        } else {
            browserChrome();
        }
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    private void browserYandex() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/WebDriver/bin/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions().setBinary("C:/Users/2306k/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
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