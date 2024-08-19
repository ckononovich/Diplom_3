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
    WebDriver driver;
    private final DataForTests dataForTests = new DataForTests();
    private final Path path = new Path();

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