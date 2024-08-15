package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.BaseHttpClient;
import model.DataForTests;
import model.Path;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.restassured.RestAssured.given;

public abstract class BaseSetupWithUserCreation {
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

    @Step("Create the user for tests")
    @Before
    public void createUser() {
        given().spec(BaseHttpClient.baseRequestSpec()).and().body(dataForTests.registrationViewForApi).when().post(path.getBasePathCreateUser());
    }

    @After
    @Step("Delete created user")
    public void deleteCreatedUser() {
        try {
            Response response = given().spec(BaseHttpClient.baseRequestSpec()).and().body(dataForTests.loginViewForApi).when().post(path.getBasePathLoginUser());
            String token = response.getBody().path("accessToken").toString();
            System.out.println(token);
            Response deleteUser = given().spec(BaseHttpClient.baseRequestSpecWithToken(token)).when().delete(path.getBasePathUser());
        } catch (Exception exception) {
            System.out.println("Nothing to delete");
        }
    }

    @After
    @Step("Close the window")
    public void quitTheWindow() {
        driver.quit();
    }
}